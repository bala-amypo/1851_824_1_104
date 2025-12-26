package com.example.demo.repository;

import com.example.demo.model.EmployeeProfile;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {

    Optional<EmployeeProfile> findByEmployeeId(String employeeId);

    Optional<EmployeeProfile> findByEmail(String email);

    List<EmployeeProfile> findAll();
}
