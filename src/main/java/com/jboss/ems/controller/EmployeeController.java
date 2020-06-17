package com.jboss.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jboss.ems.exception.ResourceNotFoundException;
import com.jboss.ems.model.Employee;
import com.jboss.ems.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/company")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/view-employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/view-employee/{id}")
    @ApiOperation(
            value = "Find Employee by ID",
            notes = "Provide a valid ID to search for an Employee",
            response = Employee.class
    )
    public Employee getEmployeeById(@ApiParam(value = "You must provide an Employee ID", required = true) @PathVariable(value = "id") Long employeeId){
       return employeeRepository.findById(employeeId).orElse(null);
    }

    @PostMapping("/add-employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        return employeeRepository.save(employee);

    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        employeeRepository.delete(employee);
        return "Employee with " + employeeId + "Successfully deleted";
    }
}