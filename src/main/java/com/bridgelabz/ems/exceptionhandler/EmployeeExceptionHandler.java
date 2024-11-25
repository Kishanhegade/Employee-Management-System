package com.bridgelabz.ems.exceptionhandler;

import com.bridgelabz.ems.exception.EmployeeNotFoundByIdException;
import com.bridgelabz.ems.exception.InvalidDepartmentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundByIdException.class)
    public ResponseEntity<String> handleEmployeeNotFoundById(EmployeeNotFoundByIdException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidDepartmentException.class)
    public ResponseEntity<String> handleInvalidDepartment(InvalidDepartmentException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
