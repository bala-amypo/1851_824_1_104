package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DeviceCatalogItemServiceImpl implements DeviceCatalogItemService {

    private final DeviceCatalogItemRepository repository;

    public DeviceCatalogItemServiceImpl(DeviceCatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceCatalogItem createItem(DeviceCatalogItem item) {

        if (item.getMaxAllowedPerEmployee() == null || item.getMaxAllowedPerEmployee() <= 0) {
            throw new BadRequestException("maxAllowedPerEmployee");
        }

        Optional<DeviceCatalogItem> existing = repository.findByDeviceCode(item.getDeviceCode());
        if (existing.isPresent()) {
            throw new BadRequestException("exists");
        }

        return repository.save(item);
    }

    @Override
    public DeviceCatalogItem updateActiveStatus(Long id, boolean active) {
        DeviceCatalogItem item = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));

        item.setActive(active);
        return repository.save(item);
    }

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return repository.findAll();
    }
}
