package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class EligibilityCheckRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private EmployeeProfile employee;

    @ManyToOne(optional = false)
    private DeviceCatalogItem device;

    private Boolean isEligible;
    private String reason;
    private LocalDateTime checkedAt;

    public EligibilityCheckRecord() {
    }

    public EligibilityCheckRecord(EmployeeProfile employee,
                                  DeviceCatalogItem device,
                                  Boolean isEligible,
                                  String reason) {
        this.employee = employee;
        this.device = device;
        this.isEligible = isEligible;
        this.reason = reason;
    }

    @PrePersist
    public void onCheck() {
        this.checkedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
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

    public Boolean getIsEligible() {
        return isEligible;
    }

    public void setIsEligible(Boolean isEligible) {
        this.isEligible = isEligible;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }
}
