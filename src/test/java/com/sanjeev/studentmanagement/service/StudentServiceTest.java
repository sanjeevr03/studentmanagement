package com.sanjeev.studentmanagement.service;

import com.sanjeev.studentmanagement.dto.StudentDTO;
import com.sanjeev.studentmanagement.exception.StudentNotFoundException;
import com.sanjeev.studentmanagement.model.Student;
import com.sanjeev.studentmanagement.repository.StudentRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
private ModelMapper modelMapper;

    @InjectMocks
    private StudentService studentService;

    @Test
void testAddStudent() {

    // Arrange
    Student student = new Student();
    student.setId(1);
    student.setName("Sanjeev");
    student.setAge(21);
    student.setDepartment("CSE");

    when(studentRepository.save(student)).thenReturn(student);

    // Act
    Student savedStudent = studentService.addStudent(student);

    // Assert
    assertEquals(student.getName(), savedStudent.getName());
    assertEquals(student.getAge(), savedStudent.getAge());
    assertEquals(student.getDepartment(), savedStudent.getDepartment());

    verify(studentRepository).save(student);
}
@Test
void testGetStudentById() {

    // Arrange
    Student student = new Student();
    student.setId(1);
    student.setName("Sanjeev");
    student.setAge(21);
    student.setDepartment("CSE");

    when(studentRepository.findById(1))
            .thenReturn(Optional.of(student));

    // Act
    Student foundStudent = studentService.getStudentById(1);

    // Assert
    assertEquals(1, foundStudent.getId());
    assertEquals("Sanjeev", foundStudent.getName());

    verify(studentRepository).findById(1);
}
@Test
void testGetStudentByIdNotFound() {

    // Arrange
    when(studentRepository.findById(100))
            .thenReturn(Optional.empty());

    // Act + Assert
    assertThrows(
            StudentNotFoundException.class,
            () -> studentService.getStudentById(100)
    );

    verify(studentRepository).findById(100);
}
@Test
void testDeleteStudent() {

    // Act
    studentService.deleteStudent(1);

    // Assert
    verify(studentRepository).deleteById(1);
}
@Test
void testUpdateStudent() {

    // Arrange
    Student existingStudent = new Student();
    existingStudent.setId(1);
    existingStudent.setName("Sanjeev");
    existingStudent.setAge(21);
    existingStudent.setDepartment("CSE");

    Student updatedStudent = new Student();
    updatedStudent.setName("Rahul");
    updatedStudent.setAge(22);
    updatedStudent.setDepartment("ECE");

    when(studentRepository.findById(1))
            .thenReturn(Optional.of(existingStudent));

    when(studentRepository.save(existingStudent))
            .thenReturn(existingStudent);

    // Act
    Student result = studentService.updateStudent(1, updatedStudent);

    // Assert
    assertEquals("Rahul", result.getName());
    assertEquals(22, result.getAge());
    assertEquals("ECE", result.getDepartment());

    verify(studentRepository).findById(1);
    verify(studentRepository).save(existingStudent);
}
@Test
void testGetAllStudents() {

    // Arrange
    Student student1 = new Student();
    student1.setId(1);
    student1.setName("Sanjeev");
    student1.setAge(21);
    student1.setDepartment("CSE");

    Student student2 = new Student();
    student2.setId(2);
    student2.setName("Rahul");
    student2.setAge(22);
    student2.setDepartment("ECE");

    when(studentRepository.findAll())
            .thenReturn(List.of(student1, student2));

    // -------- ModelMapper Mock --------

    StudentDTO dto1 = new StudentDTO();
    dto1.setId(1);
    dto1.setName("Sanjeev");
    dto1.setDepartment("CSE");

    StudentDTO dto2 = new StudentDTO();
    dto2.setId(2);
    dto2.setName("Rahul");
    dto2.setDepartment("ECE");

    when(modelMapper.map(student1, StudentDTO.class))
            .thenReturn(dto1);

    when(modelMapper.map(student2, StudentDTO.class))
            .thenReturn(dto2);

    // -------- Act --------

    List<StudentDTO> students = studentService.getAllStudents();

    // -------- Assert --------

    assertEquals(2, students.size());
    assertEquals("Sanjeev", students.get(0).getName());
    assertEquals("Rahul", students.get(1).getName());

    verify(studentRepository).findAll();
}
}