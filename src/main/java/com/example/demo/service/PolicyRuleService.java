package com.example.demo.service;

import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyRuleService {

    @Autowired
    private PolicyRuleRepository repository;

    public List<PolicyRule> getAllPolicies() {
        return repository.findAll();
    }

    public Optional<PolicyRule> getPolicyById(Long id) {
        return repository.findById(id);
    }

    public PolicyRule savePolicy(PolicyRule policy) {
        return repository.save(policy);
    }

    public void deletePolicy(Long id) {
        repository.deleteById(id);
    }
}
