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

    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }

    public Optional<PolicyRule> getRuleById(Long id) {
        return repository.findById(id);
    }

    public PolicyRule saveRule(PolicyRule rule) {
        return repository.save(rule);
    }

    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
