package com.example.demo.repository;

import com.example.demo.entity.DeviceCatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceCatalogItemRepository extends JpaRepository<DeviceCatalogItem, Long> {

    boolean existsByDeviceCode(String deviceCode);

    Optional<DeviceCatalogItem> findByDeviceCode(String deviceCode);

    Optional<DeviceCatalogItem> findByIdAndActiveTrue(Long id);
}
