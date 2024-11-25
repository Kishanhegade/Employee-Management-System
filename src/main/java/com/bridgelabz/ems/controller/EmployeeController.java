package com.bridgelabz.ems.controller;

import com.bridgelabz.ems.dto.EmployeeRequest;
import com.bridgelabz.ems.dto.EmployeeResponse;
import com.bridgelabz.ems.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employeeRequest));
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable int employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(employeeId));
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable int employeeId, @RequestBody @Valid EmployeeRequest employeeRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.updateEmployee(employeeId, employeeRequest));
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeResponse> deleteEmployee(@PathVariable int employeeId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.deleteEmployee(employeeId));
    }

    @GetMapping("/employees/dept/{dept}")
    public ResponseEntity<List<EmployeeResponse>> getEmployeesByDept(@PathVariable String dept) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeesByDept(dept));
    }
}
