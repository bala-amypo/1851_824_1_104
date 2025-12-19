package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface IssuedDeviceRecordRepository
        extends JpaRepository<IssuedDeviceRecord, Long> {

    List<IssuedDeviceRecord> findByReturned(Boolean returned);

    List<IssuedDeviceRecord> findByEmployeeIdAndReturned(Long employeeId, Boolean returned);

    List<IssuedDeviceRecord> findByDeviceIdAndReturned(Long deviceId, Boolean returned);

    Optional<IssuedDeviceRecord> findByEmployeeIdAndDeviceIdAndReturned(
            Long employeeId,
            Long deviceId,
            Boolean returned
    );

    long countByEmployeeIdAndDeviceIdAndReturned(
            Long employeeId,
            Long deviceId,
            Boolean returned
    );
}
