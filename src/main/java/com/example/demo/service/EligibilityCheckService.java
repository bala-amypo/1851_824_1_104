package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.model.EligibilityCheckRecord;
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

    public List<EligibilityCheckRecord> getAllChecks() {
        return repository.findAll();
    }

    public Optional<EligibilityCheckRecord> getCheckById(Long id) {
        return repository.findById(id);
    }

    public EligibilityCheckRecord checkEligibility(EmployeeProfile employee, DeviceCatalogItem device) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployee(employee);
        record.setDevice(device);
        record.setEligible(true); // default eligibility
        record.setReason("Eligible by default");
        record.setCheckedAt(LocalDateTime.now());
        return repository.save(record);
    }

    public EligibilityCheckRecord updateEligibility(EligibilityCheckRecord record) {
        return repository.save(record);
    }

    public void deleteEligibilityCheck(Long id) {
        repository.deleteById(id);
    }
}
