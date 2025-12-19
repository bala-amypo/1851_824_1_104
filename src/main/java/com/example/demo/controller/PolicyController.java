package com.example.demo.controller;

import com.example.demo.entity.Policy;
import com.example.demo.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @PostMapping
    public Policy addPolicy(@RequestBody Policy policy) {
        return policyService.addPolicy(policy);
    }
}
