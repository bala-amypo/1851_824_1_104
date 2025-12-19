package com.example.demo.service;

import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DeviceCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogService {

    private final DeviceCatalogRepository deviceCatalogRepository;

    public DeviceCatalogService(DeviceCatalogRepository deviceCatalogRepository) {
        this.deviceCatalogRepository = deviceCatalogRepository;
    }

    public List<DeviceCatalogItem> getAllDevices() {
        return deviceCatalogRepository.findAll();
    }

    public DeviceCatalogItem getDeviceById(Long id) {
        return deviceCatalogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id: " + id));
    }

    public DeviceCatalogItem createDevice(DeviceCatalogItem device) {
        return deviceCatalogRepository.save(device);
    }

    public DeviceCatalogItem updateDevice(Long id, DeviceCatalogItem updatedDevice) {
        DeviceCatalogItem existing = getDeviceById(id);
        existing.setDeviceCode(updatedDevice.getDeviceCode());
        existing.setDeviceType(updatedDevice.getDeviceType());
        existing.setModel(updatedDevice.getModel());
        existing.setMaxAllowedPerEmployee(updatedDevice.getMaxAllowedPerEmployee());
        return deviceCatalogRepository.save(existing);
    }

    public void deleteDevice(Long id) {
        DeviceCatalogItem existing = getDeviceById(id);
        deviceCatalogRepository.delete(existing);
    }
}
