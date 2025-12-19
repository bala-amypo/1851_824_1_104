package com.example.demo.service;

import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceCatalogService {

    private final DeviceCatalogRepository repository;

    public DeviceCatalogService(DeviceCatalogRepository repository) {
        this.repository = repository;
    }

    public List<DeviceCatalogItem> getAllDevices() {
        return repository.findAll();
    }

    public Optional<DeviceCatalogItem> getDeviceById(Long id) {
        return repository.findById(id);
    }

    public DeviceCatalogItem saveDevice(DeviceCatalogItem device) {
        return repository.save(device);
    }
}
