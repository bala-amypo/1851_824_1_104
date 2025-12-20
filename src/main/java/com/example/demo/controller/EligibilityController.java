package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    @Autowired
    private EligibilityCheckService eligibilityService;

    @PostMapping("/check")
    public AuthResponse checkEligibility(@RequestBody AuthRequest request) {
        return EligibilityCheckService.checkEligibility(request);
    }
}
