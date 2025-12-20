package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;

public interface EligibilityCheckService {
    AuthResponse checkEligibility(AuthRequest request);
}
