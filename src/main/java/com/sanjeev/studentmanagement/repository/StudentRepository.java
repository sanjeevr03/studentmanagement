package com.sanjeev.studentmanagement.repository;

import com.sanjeev.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
List<Student> findByDepartment(String department);
List<Student> findByNameContaining(String name);

}