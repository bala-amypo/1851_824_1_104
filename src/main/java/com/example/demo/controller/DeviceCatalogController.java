package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Device Catalog Endpoints")
@RestController
@RequestMapping("/api/devices")
public class DeviceCatalogController {

    private final DeviceCatalogItemService service;

    public DeviceCatalogController(DeviceCatalogItemService service) {
        this.service = service;
    }

    @Operation(summary = "Create device")
    @PostMapping
    public ResponseEntity<DeviceCatalogItem> create(@RequestBody DeviceCatalogItem item) {
        return ResponseEntity.ok(service.createItem(item));
    }

    @Operation(summary = "Get all devices")
    @GetMapping
    public ResponseEntity<List<DeviceCatalogItem>> getAll() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @Operation(summary = "Update device active status")
    @PutMapping("/{id}/active")
    public ResponseEntity<DeviceCatalogItem> updateActive(
            @PathVariable Long id,
            @RequestBody Boolean active) {

        return ResponseEntity.ok(service.updateActiveStatus(id, active));
    }

    @Operation(summary = "Delete device")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
