package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogItemServiceImpl implements DeviceCatalogItemService {

    private final DeviceCatalogItemRepository deviceRepository;

    // ✅ Constructor Injection (MANDATORY as per rules)
    public DeviceCatalogItemServiceImpl(DeviceCatalogItemRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<DeviceCatalogItem> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public DeviceCatalogItem addDevice(DeviceCatalogItem device) {

        // Duplicate deviceCode check
        deviceRepository.findByDeviceCode(device.getDeviceCode())
                .ifPresent(d -> {
                    throw new BadRequestException("exists");
                });

        // maxAllowedPerEmployee validation
        if (device.getMaxAllowedPerEmployee() == null || device.getMaxAllowedPerEmployee() <= 0) {
            throw new BadRequestException("maxAllowedPerEmployee");
        }

        // Default active = true if not set
        if (device.getActive() == null) {
            device.setActive(true);
        }

        return deviceRepository.save(device);
    }
}
