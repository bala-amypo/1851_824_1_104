package com.example.demo.repository;

import com.example.demo.model.EligibilityCheckRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EligibilityCheckRecordRepository
        extends JpaRepository<EligibilityCheckRecord, Long> {
}
