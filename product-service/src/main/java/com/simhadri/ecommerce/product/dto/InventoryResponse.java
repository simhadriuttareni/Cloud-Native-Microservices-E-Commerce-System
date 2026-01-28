package com.simhadri.ecommerce.product.dto;

import lombok.Data;

@Data
public class InventoryResponse {
    private Long productId;
    private Integer quantity;
}
