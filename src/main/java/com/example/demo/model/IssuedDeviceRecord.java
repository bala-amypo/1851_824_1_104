package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity
@Table(name = "issued_device_record")
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeProfile employee;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceCatalogItem device;

    private LocalDateTime issuedAt;

    private LocalDateTime returnedAt;

    private Boolean returned = false;

    public IssuedDeviceRecord() {
    }

    public IssuedDeviceRecord(Long id,
                              EmployeeProfile employee,
                              DeviceCatalogItem device,
                              LocalDateTime issuedAt,
                              LocalDateTime returnedAt,
                              Boolean returned) {
        this.id = id;
        this.employee = employee;
        this.device = device;
        this.issuedAt = issuedAt;
        this.returnedAt = returnedAt;
        this.returned = returned;
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

    public Boolean getReturned() {
        return returned;
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

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
