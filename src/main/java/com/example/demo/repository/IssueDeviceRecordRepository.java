package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.IssueDeviceRecord;

public interface IssueDeviceRecordRepository extends JpaRepository<IssueDeviceRecord, Long> {

}
