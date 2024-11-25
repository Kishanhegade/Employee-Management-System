package com.bridgelabz.ems.exception;

public class InvalidDepartmentException extends RuntimeException {
    private String message;

    public InvalidDepartmentException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
