package com.example.demo.service.impl;

import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityCheckServiceImpl
        implements EligibilityCheckService {

    @Override
    public boolean isEligible(Long employeeId, Long deviceId) {
        return false;
    }
}
