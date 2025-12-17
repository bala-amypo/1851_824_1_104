package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
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
    private Boolean returned = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeProfile getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeProfile employee) {
        this.employee = employee;
    }

    public DeviceCatalogItem getDevice() {
        return device;
    }

    public void setDevice(DeviceCatalogItem device) {
        this.device = device;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
    public IssuedDeviceRecord(Long id, EmployeeProfile employee,
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

public IssuedDeviceRecord() {
}

}
