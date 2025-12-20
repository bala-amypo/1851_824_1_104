// File: src/main/java/com/example/demo/service/impl/EligibilityCheckServiceDummyImpl.java
package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    @Override
    public AuthResponse checkEligibility(AuthRequest request) {
        return null;
    }
}
