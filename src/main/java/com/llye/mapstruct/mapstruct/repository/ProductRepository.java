package com.llye.mapstruct.mapstruct.repository;

import com.llye.mapstruct.mapstruct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
