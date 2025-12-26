package com.example.demo.repository;

import com.example.demo.model.DeviceCatalogItem;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceCatalogItemRepository extends JpaRepository<DeviceCatalogItem, Long> {

    Optional<DeviceCatalogItem> findByDeviceCode(String deviceCode);

    List<DeviceCatalogItem> findAll();
}
