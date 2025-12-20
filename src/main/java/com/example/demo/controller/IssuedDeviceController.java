package com.example.demo.controller;

import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issued-devices")
public class IssuedDeviceController {

    @Autowired
    private IssuedDeviceRecordService issuedService;

    @GetMapping
    public List<IssuedDeviceRecord> getAllIssuedDevices() {
        return null; // Return null
    }

    @PostMapping
    public IssuedDeviceRecord issueDevice(@RequestBody IssuedDeviceRecord record) {
        return null; // Return null
    }
}
