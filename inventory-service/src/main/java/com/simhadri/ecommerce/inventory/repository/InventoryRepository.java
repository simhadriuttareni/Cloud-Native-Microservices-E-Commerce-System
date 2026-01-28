package com.simhadri.ecommerce.inventory.repository;

import com.simhadri.ecommerce.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository
        extends JpaRepository<Inventory, Long> {

    boolean existsByProductNameAndStockGreaterThan(String productName, int stock);
}
