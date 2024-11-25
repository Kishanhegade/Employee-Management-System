package com.bridgelabz.ems.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Entity
@Getter @Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fname;
    private String lname;
    private String gender;
    private String profilepic;
    private LocalDate doj;
    @ElementCollection
    @CollectionTable(name = "employee_dept", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<String> dept;
    private double salary;
    private String note;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<Address> addresses;
}
