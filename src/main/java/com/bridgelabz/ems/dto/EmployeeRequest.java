package com.bridgelabz.ems.dto;

import com.bridgelabz.ems.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name should not exceed 50 characters")
    private String fname;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name should not exceed 50 characters")
    private String lname;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be 'Male', 'Female', or 'Other'")
    private String gender;

    @NotBlank(message = "Profile picture URL is required")
    private String profilepic;

    @NotEmpty(message = "Department list must not be empty")
    @Size(max = 5, message = "An employee can belong to a maximum of 5 departments")
    private List<@NotBlank(message = "Department name cannot be blank") String> dept;

    @Positive(message = "Salary must be a positive number")
    @Digits(integer = 10, fraction = 2, message = "Salary must be a valid amount with up to 2 decimal places")
    private double salary;

    @Size(max = 255, message = "Note must not exceed 255 characters")
    private String note;

    @NotEmpty(message = "Addresses must not be empty")
    private List<@Valid Address> addresses;
}
