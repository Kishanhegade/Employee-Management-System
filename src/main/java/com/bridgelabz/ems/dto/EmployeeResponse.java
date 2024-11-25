package com.bridgelabz.ems.dto;

import com.bridgelabz.ems.model.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class EmployeeResponse {

    private int id;
    private String fname;
    private String lname;
    private String gender;
    private String profilepic;
    private LocalDate doj;
    private List<String> dept;
    private double salary;
    private String note;
    private List<Address> addresses;
}
