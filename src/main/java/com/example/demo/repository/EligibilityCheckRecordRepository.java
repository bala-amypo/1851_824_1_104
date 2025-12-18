package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.EligibilityCheckRecord;

public interface EligibilityCheckRecordRepository extends JpaRepository<EligibilityCheckRecord, Long> {

}
