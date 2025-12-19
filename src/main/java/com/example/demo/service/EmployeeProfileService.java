package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileService {

    @Autowired
    private EmployeeProfileRepository repository;

    public List<EmployeeProfile> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<EmployeeProfile> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public EmployeeProfile saveEmployee(EmployeeProfile employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
