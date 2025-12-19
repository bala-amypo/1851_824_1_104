package com.example.demo.service;

import com.example.demo.model.IssuedDeviceRecord;
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

    public IssuedDeviceRecord createIssuedRecord(IssuedDeviceRecord record) {
        return repository.save(record);
    }

    public IssuedDeviceRecord updateIssuedRecord(IssuedDeviceRecord record) {
        return repository.save(record);
    }

    public void deleteIssuedRecord(Long id) {
        repository.deleteById(id);
    }
}
