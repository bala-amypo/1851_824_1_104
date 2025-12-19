package com.example.demo.service;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceCatalogService {

    @Autowired
    private DeviceCatalogItemRepository repository;

    public List<DeviceCatalogItem> getAllDevices() {
        return repository.findAll();
    }

    public Optional<DeviceCatalogItem> getDeviceById(Long id) {
        return repository.findById(id);
    }

    public DeviceCatalogItem saveDevice(DeviceCatalogItem device) {
        return repository.save(device);
    }

    public void deleteDevice(Long id) {
        repository.deleteById(id);
    }
}
