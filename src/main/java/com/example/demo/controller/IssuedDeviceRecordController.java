package com.example.demo.controller;

import com.example.demo.entity.IssuedDevice;
import com.example.demo.service.IssuedDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issued-devices")
public class IssuedDeviceController {

    @Autowired
    private IssuedDeviceService issuedDeviceService;

    @GetMapping
    public List<IssuedDevice> getAllIssuedDevices() {
        return issuedDeviceService.getAllIssuedDevices();
    }

    @PostMapping
    public IssuedDevice issueDevice(@RequestBody IssuedDevice device) {
        return issuedDeviceService.issueDevice(device);
    }
}
