package com.example.demo.repository;

import com.example.demo.model.EligibilityCheckRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EligibilityCheckRecordRepository extends JpaRepository<EligibilityCheckRecord, Long> {

    List<EligibilityCheckRecord> findByEmployeeId(Long employeeId);

    List<EligibilityCheckRecord> findAll();
}
