package com.example.demo.controller;

import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceCatalogueItemService deviceService;

    @GetMapping
    public List<DeviceCatalogItem> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping
    public DeviceCatalogItem addDevice(@RequestBody DeviceCatalogItem device) {
        return deviceService.addDevice(device);
    }
}
