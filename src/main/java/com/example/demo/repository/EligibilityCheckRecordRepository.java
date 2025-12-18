package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.EligibilityCheckRecordRepository;

public interface EligibilityCheckRecordRepository extends JpaRepository<EligibilityCheckRecord, Long> {

}
