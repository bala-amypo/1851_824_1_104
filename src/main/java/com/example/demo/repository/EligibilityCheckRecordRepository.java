package com.example.demo.repository;

import com.example.demo.entity.EligibilityCheckRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EligibilityCheckRecordRepository extends JpaRepository<EligibilityCheckRecord, Long> {

    List<EligibilityCheckRecord> findByEmployeeId(Long employeeId);

    List<EligibilityCheckRecord> findByEligible(Boolean eligible);
}
