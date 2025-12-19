package com.example.demo.service;

import com.example.demo.entity.IssuedDeviceRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository issuedDeviceRecordRepository;

    public IssuedDeviceRecordService(IssuedDeviceRecordRepository issuedDeviceRecordRepository) {
        this.issuedDeviceRecordRepository = issuedDeviceRecordRepository;
    }

    public List<IssuedDeviceRecord> getAllIssuedDevices() {
        return issuedDeviceRecordRepository.findAll();
    }

    public IssuedDeviceRecord getIssuedDeviceById(Long id) {
        return issuedDeviceRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Issued Device not found with id: " + id));
    }

    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
        return issuedDeviceRecordRepository.save(record);
    }

    public void revokeDevice(Long id) {
        IssuedDeviceRecord existing = getIssuedDeviceById(id);
        issuedDeviceRecordRepository.delete(existing);
    }
}
