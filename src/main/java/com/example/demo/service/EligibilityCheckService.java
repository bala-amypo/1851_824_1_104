package com.example.demo.service;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EligibilityCheckService {

    @Autowired
    private EligibilityCheckRecordRepository repository;

    public EligibilityCheckRecord save(EligibilityCheckRecord record) {
        return repository.save(record);
    }
}
