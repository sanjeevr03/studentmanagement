package com.sanjeev.studentmanagement.exception;
import com.sanjeev.studentmanagement.exception.StudentNotFoundException;


public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }

}