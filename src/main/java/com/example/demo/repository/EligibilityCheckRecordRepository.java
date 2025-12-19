 package com.example.demo.repository;

 import com.example.demo.entity.EligibilityCheckRecord;
import org.springframework.data.jpa.repository.JpaRepository;

interface EligibilityCheckRepository extends JpaRepository<EligibilityCheckRecord, Long> {
    // custom query methods if needed
}

