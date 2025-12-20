// File: src/main/java/com/example/demo/service/impl/PolicyRuleServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.model.PolicyRule;
import java.util.List;

public interface PolicyRuleServiceImpl {
    List<PolicyRule> getAllPolicies();
    PolicyRule addPolicy(PolicyRule policy);
}
