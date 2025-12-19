package com.example.demo.model;

import jakarta.persistence.model
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeviceCatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceCode;
    private String deviceType;
    private String model;
    private Integer maxAllowedPerEmployee;

    public DeviceCatalogItem() {}

    public Long getId() {
        return id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getModel() {
        return model;
    }

    public Integer getMaxAllowedPerEmployee() {
        return maxAllowedPerEmployee;
    }
}
