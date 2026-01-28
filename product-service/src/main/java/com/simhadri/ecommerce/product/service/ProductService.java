package com.simhadri.ecommerce.product.service;

import com.simhadri.ecommerce.product.dto.ProductRequestDto;
import com.simhadri.ecommerce.product.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto request);
}
