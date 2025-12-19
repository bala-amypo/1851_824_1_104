package com.example.demo.repository;

import com.example.demo.model.EmployeeProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {

    Optional<EmployeeProfile> findByEmployeeId(String employeeId);

    boolean existsByEmployeeId(String employeeId);
}
