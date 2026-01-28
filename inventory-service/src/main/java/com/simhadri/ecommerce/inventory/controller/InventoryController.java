package com.simhadri.ecommerce.inventory.controller;

import com.simhadri.ecommerce.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{productName}")
    public boolean isInStock(@PathVariable String productName) {
        return inventoryService.isInStock(productName);
    }
}
