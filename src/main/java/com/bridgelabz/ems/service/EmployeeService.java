package com.bridgelabz.ems.service;

import com.bridgelabz.ems.dto.EmployeeRequest;
import com.bridgelabz.ems.dto.EmployeeResponse;
import com.bridgelabz.ems.exception.EmployeeNotFoundByIdException;
import com.bridgelabz.ems.exception.InvalidDepartmentException;
import com.bridgelabz.ems.mapper.EmployeeMapper;
import com.bridgelabz.ems.model.Address;
import com.bridgelabz.ems.model.Employee;
import com.bridgelabz.ems.repository.AddressRepository;
import com.bridgelabz.ems.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;
    private final EmployeeMapper employeeMapper;
    private final AddressRepository addressRepo;


    public EmployeeResponse getEmployee(int employeeId) {
        return employeeRepo.findById(employeeId)
                .map(employeeMapper::mapToEmployeeResponse)
                .orElseThrow(()->new EmployeeNotFoundByIdException("Not able to find the employee"));
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();

        Employee emp = employeeMapper.mapToEmployee(employeeRequest, employee);
        emp = employeeRepo.save(emp);
        List<Address> addresses = employeeRequest.getAddresses();
        for(Address address:addresses) {
            address.setEmployee(employeeMapper.mapToEmployee(employeeRequest,employee));
            addressRepo.save(address);
        }
        return employeeMapper.mapToEmployeeResponse(emp);
    }

    public EmployeeResponse updateEmployee(int employeeId, EmployeeRequest employeeRequest) {
        List<Address> addresses = employeeRequest.getAddresses();
        for(Address address:addresses) {
            addressRepo.save(address);
        }
        return employeeRepo.findById(employeeId)
                .map(e -> {
                    e = employeeMapper.mapToEmployee(employeeRequest, e);
                    e = employeeRepo.save(e);
                    return employeeMapper.mapToEmployeeResponse(e);
                })
                .orElseThrow(() -> new EmployeeNotFoundByIdException("Not able to update the employee"));

    }

    public EmployeeResponse deleteEmployee(int employeeId) {
        return employeeRepo.findById(employeeId)
                .map(emp -> {
                    emp.getAddresses().size();
                    employeeRepo.delete(emp);
                    return employeeMapper.mapToEmployeeResponse(emp);
                }).orElseThrow(()->new EmployeeNotFoundByIdException("Not able to delete the employee..."));
    }


    public List<EmployeeResponse> getEmployeesByDept(String dept) {
        List<Employee> employees = employeeRepo.findByDeptContaining(dept);
        if(employees.isEmpty()) {
            throw new InvalidDepartmentException("Employees not found by department");
        }
        return employeeRepo.findByDeptContaining(dept)
                .stream().map(emp->{
                    emp.getAddresses().size();
                    return employeeMapper.mapToEmployeeResponse(emp);
                }).toList();
    }
}
