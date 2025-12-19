package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "issued_device")
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EmployeeProfile employee;

    @ManyToOne
    private DeviceCatalogItem device;

    private LocalDateTime issuedAt;
    private LocalDateTime returnedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ISSUED,
        RETURNED
    }

    public IssuedDeviceRecord() {
    }

    public IssuedDeviceRecord(Long id,
                              EmployeeProfile employee,
                              DeviceCatalogItem device,
                              LocalDateTime issuedAt,
                              LocalDateTime returnedAt,
                              Status status) {
        this.id = id;
        this.employee = employee;
        this.device = device;
        this.issuedAt = issuedAt;
        this.returnedAt = returnedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public EmployeeProfile getEmployee() {
        return employee;
    }

    public DeviceCatalogItem getDevice() {
        return device;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeProfile employee) {
        this.employee = employee;
    }

    public void setDevice(DeviceCatalogItem device) {
        this.device = device;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
