package com.example.demo.repository;

import com.example.demo.entity.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {
}
