package com.example.demo.service.impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogItemServiceImpl implements DeviceCatalogItemService {

    @Autowired
    private DeviceCatalogItemRepository repository;

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return repository.findAll();
    }
}
