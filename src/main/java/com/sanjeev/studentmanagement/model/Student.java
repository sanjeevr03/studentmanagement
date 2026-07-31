package com.sanjeev.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {

   @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank(message = "Department cannot be empty")
    private String department;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(Integer id, String name, Integer age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    // Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
