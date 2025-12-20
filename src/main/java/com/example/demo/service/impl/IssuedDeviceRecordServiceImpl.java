package com.example.demo.service.impl;

import com.example.demo.model.IssuedDeviceRecord;

public interface IssuedDeviceRecordServiceImpl {
    IssuedDeviceRecord issueDevice(Long employeeId, Long deviceId);
}
