package com.example.demo.service;

import com.example.demo.entity.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository repository;

    public IssuedDeviceRecordService(IssuedDeviceRecordRepository repository) {
        this.repository = repository;
    }

    public List<IssuedDeviceRecord> getAllIssuedRecords() {
        return repository.findAll();
    }

    public Optional<IssuedDeviceRecord> getIssuedRecordById(Long id) {
        return repository.findById(id);
    }

    public IssuedDeviceRecord saveIssuedRecord(IssuedDeviceRecord record) {
        return repository.save(record);
    }
}
