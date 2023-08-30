package com.llye.mapstruct.mapstruct.controller;

import com.llye.mapstruct.mapstruct.dto.ProductDto;
import com.llye.mapstruct.mapstruct.dto.ProductRequestDto;
import com.llye.mapstruct.mapstruct.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Optional<ProductDto> maybeProduct = productService.create(productRequestDto);
        return maybeProduct.map(product -> new ResponseEntity<>(product, HttpStatus.CREATED))
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                                           @RequestParam(defaultValue = "10") int pageSize) {
        List<ProductDto> productDtos = productService.getAllProducts(pageNumber, pageSize);
        if (CollectionUtils.isEmpty(productDtos)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
}
