package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeProfileService employeeService;

    @GetMapping
    public List<EmployeeProfile> getAllEmployees() {
        return EmployeeProfileService.getAllEmployees();
    }

    @PostMapping
    public EmployeeProfile addEmployee(@RequestBody EmployeeProfile employee) {
        return EmployeeProfileService.addEmployee(employee);
    }
}
