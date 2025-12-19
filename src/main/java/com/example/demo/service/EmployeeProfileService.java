package com.example.demo.service;

import com.example.demo.entity.EmployeeProfile;
import com.example.demo.dto.EmployeeProfileDTO;
import com.example.demo.repository.EmployeeProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileService(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeProfileDTO> getAllEmployees() {
        return repository.findAll().stream()
                .map(e -> new EmployeeProfileDTO(e.getId(), e.getName(), e.getEmail(), e.getJoiningDate()))
                .collect(Collectors.toList());
    }

    public Optional<EmployeeProfile> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public EmployeeProfile saveEmployee(EmployeeProfile employee) {
        return repository.save(employee);
    }
}

