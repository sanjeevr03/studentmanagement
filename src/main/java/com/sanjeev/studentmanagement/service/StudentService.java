package com.sanjeev.studentmanagement.service;

import com.sanjeev.studentmanagement.exception.StudentNotFoundException;
import com.sanjeev.studentmanagement.model.Student;
import com.sanjeev.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sanjeev.studentmanagement.dto.StudentDTO;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
private ModelMapper modelMapper;
@Autowired
private FileStorageService fileStorageService;
private static final Logger logger =
        LoggerFactory.getLogger(StudentService.class);

   public List<StudentDTO> getAllStudents() {

    List<Student> students = studentRepository.findAll();

    List<StudentDTO> studentDTOList = new ArrayList<>();

    for (Student student : students) {
StudentDTO dto = modelMapper.map(student, StudentDTO.class);

        studentDTOList.add(dto);
    }

    return studentDTOList;
}

  public Student addStudent(Student student) {

    logger.info("Adding student: {}", student.getName());

    Student savedStudent = studentRepository.save(student);

    logger.info("Student added successfully with ID: {}", savedStudent.getId());

    return savedStudent;
}

    public Student updateStudent(Integer id, Student updatedStudent) {

    logger.info("Updating student with ID: {}", id);

    Student student = studentRepository.findById(id).orElse(null);

    if (student != null) {
        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());
        student.setDepartment(updatedStudent.getDepartment());

        logger.info("Student updated successfully.");

        return studentRepository.save(student);
    }

    logger.warn("Student with ID {} not found for update.", id);

    return null;
}

   public void deleteStudent(Integer id) {

    logger.info("Deleting student with ID: {}", id);

    studentRepository.deleteById(id);

    logger.info("Student deleted successfully.");
}
    public Student getStudentById(Integer id) {

    logger.info("Searching for student with ID: {}", id);

    return studentRepository.findById(id)
            .orElseThrow(() -> {
                logger.error("Student with ID {} not found.", id);
                return new StudentNotFoundException(
                        "Student with ID " + id + " not found");
            });
}
public List<StudentDTO> getStudentsByDepartment(String department) {

    List<Student> students = studentRepository.findByDepartment(department);

    List<StudentDTO> studentDTOList = new ArrayList<>();

    for (Student student : students) {

        StudentDTO dto = modelMapper.map(student, StudentDTO.class);

        studentDTOList.add(dto);
    }

    return studentDTOList;
}
public List<StudentDTO> searchStudentsByName(String name) {

    List<Student> students = studentRepository.findByNameContaining(name);

    List<StudentDTO> studentDTOList = new ArrayList<>();

    for (Student student : students) {

        StudentDTO dto = modelMapper.map(student, StudentDTO.class);

        studentDTOList.add(dto);
    }

    return studentDTOList;
}
public Page<StudentDTO> getStudentsWithPagination(
        int page,
        int size,
        String field) {

    Page<Student> students = studentRepository.findAll(
            PageRequest.of(page, size,
                    org.springframework.data.domain.Sort.by(field)));

    return students.map(student ->
            modelMapper.map(student, StudentDTO.class));
}

public List<StudentDTO> getStudentsSorted(String field) {

    List<Student> students = studentRepository.findAll(
            org.springframework.data.domain.Sort.by(field));

    List<StudentDTO> studentDTOList = new ArrayList<>();

    for (Student student : students) {

        StudentDTO dto = modelMapper.map(student, StudentDTO.class);

        studentDTOList.add(dto);
    }

    return studentDTOList;
}
public Student uploadStudentImage(Integer id,
                                  MultipartFile file) throws IOException {

    Student student = studentRepository.findById(id)
            .orElseThrow(() ->
                    new StudentNotFoundException(
                            "Student with ID " + id + " not found"));

    String filePath = fileStorageService.saveFile(file);

    student.setImageUrl(filePath);

    return studentRepository.save(student);
}
}
