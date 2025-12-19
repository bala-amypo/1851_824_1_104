package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {

    Optional<IssuedDeviceRecord> findByEmployeeIdAndDeviceIdAndStatus(
            Long employeeId,
            Long deviceId,
            IssuedDeviceRecord.Status status
    );

    List<IssuedDeviceRecord> findByEmployeeIdAndStatus(
            Long employeeId,
            IssuedDeviceRecord.Status status
    );

    long countByEmployeeIdAndDeviceIdAndStatus(
            Long employeeId,
            Long deviceId,
            IssuedDeviceRecord.Status status
    );
}
