package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelclass.DeviceCatalogItem;

public interface DeviceCatalogItemRepository extends JpaRepository<DeviceCatalogItem, Long> {

}
