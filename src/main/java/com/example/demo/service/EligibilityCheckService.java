package com.example.demo.service;

import com.example.demo.entity.EmployeeProfile;
import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.entity.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EligibilityCheckService {

    private final EligibilityCheckRepository repository;

    public EligibilityCheckService(EligibilityCheckRepository repository) {
        this.repository = repository;
    }

    public List<EligibilityCheckRecord> getAllEligibilityChecks() {
        return repository.findAll();
    }

    public Optional<EligibilityCheckRecord> getEligibilityCheckById(Long id) {
        return repository.findById(id);
    }

    public EligibilityCheckRecord checkEligibility(EmployeeProfile employee, DeviceCatalogItem device) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployee(employee);
        record.setDevice(device);
        record.setEligible(true); // placeholder logic
        record.setReason("Default eligibility approved");
        record.setCheckedAt(LocalDateTime.now());
        return repository.save(record);
    }
}
