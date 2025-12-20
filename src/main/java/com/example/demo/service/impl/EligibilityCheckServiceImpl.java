package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;

public interface EligibilityCheckServiceImpl {
    AuthResponse checkEligibility(AuthRequest request);
}
