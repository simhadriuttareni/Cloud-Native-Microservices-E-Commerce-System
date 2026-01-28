package com.simhadri.ecommerce.inventory.service.impl;

import com.simhadri.ecommerce.inventory.repository.InventoryRepository;
import com.simhadri.ecommerce.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public boolean isInStock(String productName) {
        return inventoryRepository
                .existsByProductNameAndStockGreaterThan(productName, 0);
    }
}
