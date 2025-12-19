package com.example.demo.repository;

import com.example.demo.entity.DeviceCatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

// remove 'public' keyword
interface DeviceCatalogRepository extends JpaRepository<DeviceCatalogItem, Long> {
    // custom query methods if needed
}
