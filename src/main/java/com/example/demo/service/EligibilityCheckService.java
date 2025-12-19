package com.example.demo.service;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EligibilityCheckService {

    @Autowired
    private EligibilityCheckRecordRepository repository;

    public List<EligibilityCheckRecord> getAllChecks() {
        return repository.findAll();
    }

    public Optional<EligibilityCheckRecord> getCheckById(Long id) {
        return repository.findById(id);
    }

    public EligibilityCheckRecord saveCheck(EligibilityCheckRecord record) {
        return repository.save(record);
    }

    public void deleteCheck(Long id) {
        repository.deleteById(id);
    }
}
