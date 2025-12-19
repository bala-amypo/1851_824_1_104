package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {}
