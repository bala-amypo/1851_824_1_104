package com.example.demo.controller;

import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<DeviceCatalogItem> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public DeviceCatalogItem getDevice(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping
    public DeviceCatalogItem createDevice(@RequestBody DeviceCatalogItem device) {
        return deviceService.createDevice(device);
    }

    @PutMapping("/{id}")
    public DeviceCatalogItem updateDevice(@PathVariable Long id, @RequestBody DeviceCatalogItem device) {
        return deviceService.updateDevice(id, device);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }
}
