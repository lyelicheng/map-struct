package com.llye.mapstruct.mapstruct.service;

import com.llye.mapstruct.mapstruct.dto.ProductDto;
import com.llye.mapstruct.mapstruct.dto.ProductRequestDto;
import com.llye.mapstruct.mapstruct.entity.Product;
import com.llye.mapstruct.mapstruct.mapper.ProductMapper;
import com.llye.mapstruct.mapstruct.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<ProductDto> create(ProductRequestDto productRequestDto) {
        Product product = productRepository.save(Product.builder()
                                                        .name(productRequestDto.getName())
                                                        .price(productRequestDto.getPrice()
                                                                                .setScale(2, RoundingMode.DOWN))
                                                        .build());
        return Optional.of(ProductMapper.INSTANCE.productToProductDto(product));
    }

    public List<ProductDto> getAllProducts(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "updatedAt"));
        Page<Product> productPage = productRepository.findAll(pageRequest);
        List<Product> products = productPage.getContent();
        if (products.isEmpty()) {
            return Collections.emptyList();
        }
        return ProductMapper.INSTANCE.productsToProductDtos(products);
    }
}
