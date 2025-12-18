package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelclass.IssueDeviceRecord;

public interface IssueDeviceRecordRepository extends JpaRepository<IssueDeviceRecord, Long> {

}
