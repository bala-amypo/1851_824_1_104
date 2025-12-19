package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyRuleService policyService;

    @GetMapping
    public List<PolicyRule> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @PostMapping
    public Policy addPolicy(@RequestBody Policy policy) {
        return policyService.addPolicy(policy);
    }
}
