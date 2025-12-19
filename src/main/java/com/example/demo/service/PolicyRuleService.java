package com.example.demo.service;

import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyRuleService {
    private final PolicyRuleRepository repository;

    public PolicyRuleService(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    public List<PolicyRule> getAllPolicies() {
        return repository.findAll();
    }

    public Optional<PolicyRule> getPolicyById(Long id) {
        return repository.findById(id);
    }

    public PolicyRule createPolicy(PolicyRule policy) {
        return repository.save(policy);
    }

    public PolicyRule updatePolicy(PolicyRule policy) {
        return repository.save(policy);
    }

    public void deletePolicy(Long id) {
        repository.deleteById(id);
    }
}
