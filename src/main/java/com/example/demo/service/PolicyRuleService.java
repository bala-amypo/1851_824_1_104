package com.example.demo.service;

import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyRuleService {

    private final PolicyRuleRepository policyRuleRepository;

    public PolicyRuleService(PolicyRuleRepository policyRuleRepository) {
        this.policyRuleRepository = policyRuleRepository;
    }

    public List<PolicyRule> getAllPolicies() {
        return policyRuleRepository.findAll();
    }

    public Optional<PolicyRule> getPolicyById(Long id) {
        return policyRuleRepository.findById(id);
    }

    public PolicyRule createPolicy(PolicyRule policyRule) {
        return policyRuleRepository.save(policyRule);
    }

    public PolicyRule updatePolicy(Long id, PolicyRule policyRule) {
        PolicyRule existing = policyRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
        existing.setPolicyName(policyRule.getPolicyName());
        existing.setDescription(policyRule.getDescription());
        return policyRuleRepository.save(existing);
    }

    public void deletePolicy(Long id) {
        policyRuleRepository.deleteById(id);
    }
}
