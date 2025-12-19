package com.example.demo.repository;

import com.example.demo.entity.EligibilityCheckRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibilityCheckRepository extends JpaRepository<EligibilityCheckRecord, Long> {
}
