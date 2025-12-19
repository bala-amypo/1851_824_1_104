package com.example.demo.service;

import com.example.demo.dto.EmployeeProfileDTO;
import com.example.demo.entity.EmployeeProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileService {

    private final EmployeeProfileRepository employeeProfileRepository;

    public EmployeeProfileService(EmployeeProfileRepository employeeProfileRepository) {
        this.employeeProfileRepository = employeeProfileRepository;
    }

    public List<EmployeeProfile> getAllEmployees() {
        return employeeProfileRepository.findAll();
    }

    public EmployeeProfile getEmployeeById(Long id) {
        return employeeProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public EmployeeProfile createEmployee(EmployeeProfile employeeProfile) {
        return employeeProfileRepository.save(employeeProfile);
    }

    public EmployeeProfile updateEmployee(Long id, EmployeeProfile updatedProfile) {
        EmployeeProfile existing = getEmployeeById(id);
        existing.setName(updatedProfile.getName());
        existing.setDepartment(updatedProfile.getDepartment());
        existing.setEmail(updatedProfile.getEmail());
        return employeeProfileRepository.save(existing);
    }

    public void deleteEmployee(Long id) {
        EmployeeProfile existing = getEmployeeById(id);
        employeeProfileRepository.delete(existing);
    }
}
