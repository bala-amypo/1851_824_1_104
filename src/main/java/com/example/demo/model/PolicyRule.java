package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "policy_rule")
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String deviceType;
    private Integer maxAllowed;
    private Boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getMaxAllowed() {
        return maxAllowed;
    }

    public void setMaxAllowed(Integer maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    public PolicyRule(Long id, String ruleName,
                  String deviceType, Integer maxAllowed,
                  Boolean active) {
    this.id = id;
    this.ruleName = ruleName;
    this.deviceType = deviceType;
    this.maxAllowed = maxAllowed;
    this.active = active;
}

public PolicyRule() {
}

}
