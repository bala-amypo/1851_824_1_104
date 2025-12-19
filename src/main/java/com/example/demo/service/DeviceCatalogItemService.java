package com.example.demo.service;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogItemService {

    @Autowired
    private DeviceCatalogItemRepository repository;

    public List<DeviceCatalogItem> getAllDevices() {
        return repository.findAll();
    }

    public DeviceCatalogItem save(DeviceCatalogItem item) {
        return repository.save(item);
    }
}
