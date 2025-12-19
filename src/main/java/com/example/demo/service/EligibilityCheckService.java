package com.example.demo.service;

import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.entity.EmployeeProfile;
import com.example.demo.entity.EligibilityCheckRecord;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.EligibilityCheckRepository;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EligibilityCheckService {

    private final EligibilityCheckRepository eligibilityCheckRepository;
    private final IssuedDeviceRecordRepository issuedDeviceRecordRepository;

    public EligibilityCheckService(EligibilityCheckRepository eligibilityCheckRepository,
                                   IssuedDeviceRecordRepository issuedDeviceRecordRepository) {
        this.eligibilityCheckRepository = eligibilityCheckRepository;
        this.issuedDeviceRecordRepository = issuedDeviceRecordRepository;
    }

    public EligibilityCheckRecord checkEligibility(EmployeeProfile employee, DeviceCatalogItem device) {

        long issuedCount = issuedDeviceRecordRepository.countByEmployeeAndDevice(employee, device);

        if (issuedCount >= device.getMaxAllowedPerEmployee()) {
            EligibilityCheckRecord record = new EligibilityCheckRecord(null, employee, device, false,
                    "Max allowed devices already issued", LocalDateTime.now());
            return eligibilityCheckRepository.save(record);
        }

        EligibilityCheckRecord record = new EligibilityCheckRecord(null, employee, device, true,
                "Eligible to issue device", LocalDateTime.now());
        return eligibilityCheckRepository.save(record);
    }
}
