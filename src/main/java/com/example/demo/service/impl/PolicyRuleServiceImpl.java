// File: src/main/java/com/example/demo/service/impl/PolicyRuleServiceDummyImpl.java
package com.example.demo.service.impl;

import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyRuleServiceDummyImpl implements PolicyRuleService {

    @Override
    public List<PolicyRule> getAllPolicies() {
        return null; // dummy return
    }

    @Override
    public PolicyRule addPolicy(PolicyRule policy) {
        return null; // dummy return
    }
}
