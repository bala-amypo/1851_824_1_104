package com.example.demo.service.impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviceCatalogItemServiceImpl
        implements DeviceCatalogItemService {

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return repository.findAll();;
    }
}
