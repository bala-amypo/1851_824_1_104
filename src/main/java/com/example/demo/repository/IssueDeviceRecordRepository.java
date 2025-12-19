package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.IssueDeviceRecord;

public interface IssueDeviceRecordRepository extends JpaRepository<IssueDeviceRecord, Long> {

}
