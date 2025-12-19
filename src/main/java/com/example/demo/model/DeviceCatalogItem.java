package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "device_catalog")
public class DeviceCatalogItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceCode;
    private String deviceType;
    private String model;
    private Integer maxAllowedPerEmployee;

    public DeviceCatalogItem() {}

    public DeviceCatalogItem(String deviceCode, String deviceType, String model, Integer maxAllowedPerEmployee) {
        this.deviceCode = deviceCode;
        this.deviceType = deviceType;
        this.model = model;
        this.maxAllowedPerEmployee = maxAllowedPerEmployee;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeviceCode() { return deviceCode; }
    public void setDeviceCode(String deviceCode) { this.deviceCode = deviceCode; }

    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getMaxAllowedPerEmployee() { return maxAllowedPerEmployee; }
    public void setMaxAllowedPerEmployee(Integer maxAllowedPerEmployee) { this.maxAllowedPerEmployee = maxAllowedPerEmployee; }
}
