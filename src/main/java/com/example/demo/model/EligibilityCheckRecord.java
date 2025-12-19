package com.example.demo.model;

import jakarta.persistence.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class EligibilityCheckRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EmployeeProfile employee;

    @ManyToOne
    private DeviceCatalogItem device;

    private Boolean eligible;
    private String reason;
    private LocalDateTime checkedAt;

    public EligibilityCheckRecord() {}

    public EligibilityCheckRecord(Long id, EmployeeProfile employee, DeviceCatalogItem device, Boolean eligible, String reason, LocalDateTime checkedAt) {
        this.id = id;
        this.employee = employee;
        this.device = device;
        this.eligible = eligible;
        this.reason = reason;
        this.checkedAt = checkedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public EmployeeProfile getEmployee() { return employee; }
    public void setEmployee(EmployeeProfile employee) { this.employee = employee; }

    public DeviceCatalogItem getDevice() { return device; }
    public void setDevice(DeviceCatalogItem device) { this.device = device; }

    public Boolean getEligible() { return eligible; }
    public void setEligible(Boolean eligible) { this.eligible = eligible; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public LocalDateTime getCheckedAt() { return checkedAt; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
}
