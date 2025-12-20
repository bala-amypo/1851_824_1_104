// File: src/main/java/com/example/demo/service/impl/DeviceCatalogItemServiceDummyImpl.java
package com.example.demo.service.impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogItemService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceCatalogItemServiceImpl implements DeviceCatalogItemService {

    @Override
    public List<DeviceCatalogItem> getAllDevices() {
        return null;
    }

    @Override
    public DeviceCatalogItem addDevice(DeviceCatalogItem device) {
        return null;
    }
}
