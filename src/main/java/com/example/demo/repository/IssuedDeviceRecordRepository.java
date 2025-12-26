package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {

    @Query("""
           SELECT r FROM IssuedDeviceRecord r
           WHERE r.employee.id = :employeeId
             AND r.device.id = :deviceItemId
             AND r.status = 'ISSUED'
           """)
    List<IssuedDeviceRecord> findActiveByEmployeeAndDevice(Long employeeId, Long deviceItemId);

    @Query("""
           SELECT COUNT(r) FROM IssuedDeviceRecord r
           WHERE r.employee.id = :employeeId
             AND r.status = 'ISSUED'
           """)
    Long countActiveDevicesForEmployee(Long employeeId);

    List<IssuedDeviceRecord> findByEmployeeId(Long employeeId);

    List<IssuedDeviceRecord> findAll();
}
