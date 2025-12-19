package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EmployeeProfile employee;

    @ManyToOne
    private DeviceCatalogItem device;

    private LocalDateTime issuedAt;

    public IssuedDeviceRecord() {}

    public IssuedDeviceRecord(Long id, EmployeeProfile employee, DeviceCatalogItem device, LocalDateTime issuedAt) {
        this.id = id;
        this.employee = employee;
        this.device = device;
        this.issuedAt = issuedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public EmployeeProfile getEmployee() { return employee; }
    public void setEmployee(EmployeeProfile employee) { this.employee = employee; }

    public DeviceCatalogItem getDevice() { return device; }
    public void setDevice(DeviceCatalogItem device) { this.device = device; }

    public LocalDateTime getIssuedAt() { return issuedAt; }
    public void setIssuedAt(LocalDateTime issuedAt) { this.issuedAt = issuedAt; }
}
