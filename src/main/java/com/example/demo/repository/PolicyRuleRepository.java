package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.PolicyRule;

public interface PolicyRuleRepository  extends JpaRepository<PolicyRule, Long> {

}
