package com.example.demo.controller;

import com.example.demo.dto.EligibilityCheckRequest;
import com.example.demo.dto.EligibilityCheckResponse;
import com.example.demo.service.EligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    @Autowired
    private EligibilityService eligibilityService;

    @PostMapping("/check")
    public EligibilityCheckResponse checkEligibility(@RequestBody EligibilityCheckRequest request) {
        return eligibilityService.checkEligibility(request);
    }
}
