package com.bridgelabz.ems.mapper;

import com.bridgelabz.ems.dto.EmployeeRequest;
import com.bridgelabz.ems.dto.EmployeeResponse;
import com.bridgelabz.ems.model.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeMapper {

    public Employee mapToEmployee(EmployeeRequest employeeRequest, Employee employee) {
        employee.setFname(employeeRequest.getFname());
        employee.setLname(employeeRequest.getLname());
        employee.setGender(employeeRequest.getGender());
        employee.setProfilepic(employeeRequest.getProfilepic());
        employee.setSalary(employeeRequest.getSalary());
        employee.setDept(employeeRequest.getDept());
        employee.setAddresses(employeeRequest.getAddresses());
        employee.setNote(employeeRequest.getNote());
        employee.setDoj(LocalDate.now()
        );
        return employee;
    }

    public EmployeeResponse mapToEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setFname(employee.getFname());
        employeeResponse.setLname(employee.getLname());
        employeeResponse.setGender(employee.getGender());
        employeeResponse.setProfilepic(employee.getProfilepic());
        employeeResponse.setDoj(employee.getDoj());
        employeeResponse.setSalary(employee.getSalary());
        employeeResponse.setNote(employee.getNote());
        employeeResponse.setDept(employee.getDept());
        employeeResponse.setAddresses(employee.getAddresses());
        return employeeResponse;
    }
}
