package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.dto.EmployeeProfileDTO;
import com.example.demo.repository.EmployeeProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileService {
    private final EmployeeProfileRepository repository;

    public EmployeeProfileService(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeProfile> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<EmployeeProfile> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public EmployeeProfile createEmployee(EmployeeProfileDTO dto) {
        EmployeeProfile emp = new EmployeeProfile();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        return repository.save(emp);
    }

    public EmployeeProfile updateEmployee(Long id, EmployeeProfileDTO dto) {
        Optional<EmployeeProfile> optional = repository.findById(id);
        if (optional.isPresent()) {
            EmployeeProfile emp = optional.get();
            emp.setName(dto.getName());
            emp.setEmail(dto.getEmail());
            return repository.save(emp);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
