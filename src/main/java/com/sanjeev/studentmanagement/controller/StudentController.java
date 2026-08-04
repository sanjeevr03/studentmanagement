package com.sanjeev.studentmanagement.controller;

import com.sanjeev.studentmanagement.dto.StudentDTO;
import com.sanjeev.studentmanagement.model.Student;
import com.sanjeev.studentmanagement.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@Tag(
        name = "Student Controller",
        description = "APIs for managing students in the Student Management System"
)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(
            summary = "Get all students",
            description = "Returns a list of all students."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Students retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents() {

        List<StudentDTO> students = studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }

    @Operation(
            summary = "Get student by ID",
            description = "Returns a student using the given ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {

        Student student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

    @Operation(
            summary = "Get students by department",
            description = "Returns all students belonging to the specified department."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Students retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @GetMapping("/students/department/{department}")
    public ResponseEntity<List<StudentDTO>> getStudentsByDepartment(
            @PathVariable String department) {

        List<StudentDTO> students =
                studentService.getStudentsByDepartment(department);

        return ResponseEntity.ok(students);
    }

    @Operation(
            summary = "Search students by name",
            description = "Searches students whose names match the given keyword."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Students found"),
            @ApiResponse(responseCode = "404", description = "No matching students found")
    })
    @GetMapping("/students/search/{name}")
    public ResponseEntity<List<StudentDTO>> searchStudentsByName(
            @PathVariable String name) {

        List<StudentDTO> students =
                studentService.searchStudentsByName(name);

        return ResponseEntity.ok(students);
    }

    @Operation(
            summary = "Add a new student",
            description = "Creates a new student in the database. ADMIN role required."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Student created successfully"),
            @ApiResponse(responseCode = "400", description = "Validation failed"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Access denied")
    })
    @PostMapping("/students")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Student> addStudent(
            @Valid @RequestBody Student student) {

        Student savedStudent = studentService.addStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedStudent);
    }

    @Operation(
            summary = "Delete student",
            description = "Deletes a student by ID. ADMIN role required."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "403", description = "Access denied")
    })
    @DeleteMapping("/students/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Integer id) {

        studentService.deleteStudent(id);

        return ResponseEntity.ok("Student deleted successfully!");
    }

    @Operation(
            summary = "Get students with pagination",
            description = "Returns students using pagination and sorting."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Students retrieved successfully")
    })
    @GetMapping("/students/page")
    public ResponseEntity<Page<StudentDTO>> getStudentsWithPagination(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort) {

        return ResponseEntity.ok(
                studentService.getStudentsWithPagination(page, size, sort));
    }

    @Operation(
            summary = "Sort students",
            description = "Returns all students sorted by the specified field."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Students sorted successfully")
    })
    @GetMapping("/students/sort/{field}")
    public ResponseEntity<List<StudentDTO>> getStudentsSorted(
            @PathVariable String field) {

        List<StudentDTO> students =
                studentService.getStudentsSorted(field);

        return ResponseEntity.ok(students);
    }
   @PostMapping(
        value = "/students/{id}/upload",
        consumes = "multipart/form-data"
)
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Student> uploadStudentImage(
        @PathVariable Integer id,
        @RequestParam("file") MultipartFile file)
        throws IOException {

    Student student = studentService.uploadStudentImage(id, file);

    return ResponseEntity.ok(student);
}
}