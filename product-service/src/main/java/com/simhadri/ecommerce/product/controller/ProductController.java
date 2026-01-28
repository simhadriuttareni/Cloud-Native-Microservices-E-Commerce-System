package com.simhadri.ecommerce.product.controller;

import com.simhadri.ecommerce.product.dto.ProductRequestDto;
import com.simhadri.ecommerce.product.dto.ProductResponseDto;
import com.simhadri.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(
            @RequestBody ProductRequestDto request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }
}
