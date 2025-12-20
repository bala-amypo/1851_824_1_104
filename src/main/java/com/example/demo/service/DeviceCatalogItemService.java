package com.example.demo.service;

import com.example.demo.model.DeviceCatalogItem;
import java.util.List;

public interface DeviceCatalogItemService {
    List<DeviceCatalogItem> getAllDevices();
    DeviceCatalogItem addDevice(DeviceCatalogItem device);
}
