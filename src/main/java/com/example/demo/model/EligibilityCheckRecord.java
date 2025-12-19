package com.example.demo.model;
import jakarta.persistence.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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

    public EligibilityCheckRecord() {}

    public Long getId() {
        return id;
    }

    public Boolean getEligible() {
        return eligible;
    }

    public String getReason() {
        return reason;
    }
}
