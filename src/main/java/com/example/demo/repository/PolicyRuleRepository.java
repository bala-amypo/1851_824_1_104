package com.example.demo.repository;

import com.example.demo.entity.PolicyRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {

    List<PolicyRule> findByActiveTrue();

    List<PolicyRule> findByActiveTrueAndRole(String role);

    List<PolicyRule> findByActiveTrueAndDepartment(String department);

    List<PolicyRule> findByActiveTrueAndRoleAndDepartment(String role, String department);
}
