package com.example.demo.controller;

import com.example.demo.entity.EmployeeProfile;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeProfile> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeProfile addEmployee(@RequestBody EmployeeProfile employee) {
        return employeeService.addEmployee(employee);
    }
}
