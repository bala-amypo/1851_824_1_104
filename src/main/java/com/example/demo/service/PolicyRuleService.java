package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleService {

    private final PolicyRuleRepository policyRuleRepository;

    public PolicyRuleService(PolicyRuleRepository policyRuleRepository) {
        this.policyRuleRepository = policyRuleRepository;
    }

    public List<PolicyRule> getAllPolicies() {
        return policyRuleRepository.findAll();
    }

    public PolicyRule getPolicyById(Long id) {
        return policyRuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found with id: " + id));
    }

    public PolicyRule createPolicy(PolicyRule policyRule) {
        return policyRuleRepository.save(policyRule);
    }

    public PolicyRule updatePolicy(Long id, PolicyRule updatedPolicy) {
        PolicyRule existing = getPolicyById(id);
        existing.setDeviceType(updatedPolicy.getDeviceType());
        existing.setMaxAllowed(updatedPolicy.getMaxAllowed());
        return policyRuleRepository.save(existing);
    }

    public void deletePolicy(Long id) {
        PolicyRule existing = getPolicyById(id);
        policyRuleRepository.delete(existing);
    }
}
