package com.example.demo.service.impl;

import com.example.demo.model.PolicyRule;
import java.util.List;

public interface PolicyRuleServiceImpl {
    List<PolicyRule> getAllPolicies();
    PolicyRule addPolicy(PolicyRule policy);
}
