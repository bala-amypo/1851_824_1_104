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

    public List<IssuedDeviceRecord> getAllIssuedDevices() {
        return repository.findAll();
    }

    public Optional<IssuedDeviceRecord> getIssuedDeviceById(Long id) {
        return repository.findById(id);
    }

    public IssuedDeviceRecord saveIssuedDevice(IssuedDeviceRecord record) {
        return repository.save(record);
    }

    public void deleteIssuedDevice(Long id) {
        repository.deleteById(id);
    }
}
