package com.example.demo.repository;

import com.example.demo.model.PolicyRule;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {

    List<PolicyRule> findByActiveTrue();

    Optional<PolicyRule> findByRuleCode(String ruleCode);

    List<PolicyRule> findAll();
}
