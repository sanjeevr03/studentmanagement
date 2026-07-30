package com.sanjeev.studentmanagement.controller;

import com.sanjeev.studentmanagement.model.Student;
import com.sanjeev.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.sanjeev.studentmanagement.dto.StudentDTO;
import com.sanjeev.studentmanagement.service.StudentService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

   @GetMapping("/students")
public ResponseEntity<List<StudentDTO>> getStudents() {

    List<StudentDTO> students = studentService.getAllStudents();

    return ResponseEntity.ok(students);
}
@GetMapping("/students/department/{department}")
public ResponseEntity<List<StudentDTO>> getStudentsByDepartment(
        @PathVariable String department) {

    List<StudentDTO> students = studentService.getStudentsByDepartment(department);

    return ResponseEntity.ok(students);
}
@GetMapping("/students/search/{name}")
public ResponseEntity<List<StudentDTO>> searchStudentsByName(
        @PathVariable String name) {

    List<StudentDTO> students = studentService.searchStudentsByName(name);

    return ResponseEntity.ok(students);
}



 @PostMapping("/students")
public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {

    Student savedStudent = studentService.addStudent(student);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
}

   @PutMapping("/students/{id}")
public ResponseEntity<Student> updateStudent(
        @PathVariable Integer id,
        @RequestBody Student updatedStudent) {

    Student student = studentService.updateStudent(id, updatedStudent);

    return ResponseEntity.ok(student);
}


    @DeleteMapping("/students/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {

    studentService.deleteStudent(id);

    return ResponseEntity.ok("Student deleted successfully!");
}

    @GetMapping("/students/{id}")
public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {

    Student student = studentService.getStudentById(id);

    return ResponseEntity.ok(student);
}
@GetMapping("/students/page")
public ResponseEntity<Page<StudentDTO>> getStudentsWithPagination(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String sort) {

    return ResponseEntity.ok(
            studentService.getStudentsWithPagination(page, size, sort));
}
@GetMapping("/students/sort/{field}")
public ResponseEntity<List<StudentDTO>> getStudentsSorted(
        @PathVariable String field) {

    List<StudentDTO> students = studentService.getStudentsSorted(field);

    return ResponseEntity.ok(students);
}
}