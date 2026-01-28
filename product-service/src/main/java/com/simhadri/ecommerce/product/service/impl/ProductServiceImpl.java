package com.simhadri.ecommerce.product.service.impl;

import com.simhadri.ecommerce.product.dto.ProductRequestDto;
import com.simhadri.ecommerce.product.dto.ProductResponseDto;
import com.simhadri.ecommerce.product.entity.Product;
import com.simhadri.ecommerce.product.exception.OutOfStockException;
import com.simhadri.ecommerce.product.repository.ProductRepository;
import com.simhadri.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final WebClient webClient;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto request) {

        Boolean inStock = webClient.get()
                .uri("http://inventory-service/api/inventory/{name}", request.name())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (Boolean.FALSE.equals(inStock)) {
            throw new OutOfStockException("Product out of stock");
        }

        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();

        productRepository.save(product);

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
