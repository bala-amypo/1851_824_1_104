package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelclass.EmployeeProfile;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {

}
