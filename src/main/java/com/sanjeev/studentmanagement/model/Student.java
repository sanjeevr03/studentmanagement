package com.sanjeev.studentmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Schema(
        name = "Student",
        description = "Represents a student in the Student Management System"
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "Unique ID of the student",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    @Schema(
            description = "Full name of the student",
            example = "Sanjeev"
    )
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Schema(
            description = "Age of the student",
            example = "21",
            minimum = "18"
    )
    private Integer age;

    @NotBlank(message = "Department cannot be empty")
    @Schema(
            description = "Department of the student",
            example = "Computer Science and Engineering"
    )
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
    private String imageUrl;

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
    public String getImageUrl() {
    return imageUrl;
}

public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
}
}