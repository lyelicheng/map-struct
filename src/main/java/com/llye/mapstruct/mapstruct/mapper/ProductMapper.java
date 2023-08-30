package com.llye.mapstruct.mapstruct.mapper;

import com.llye.mapstruct.mapstruct.dto.ProductDto;
import com.llye.mapstruct.mapstruct.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "productPrice")
    ProductDto productToProductDto(Product product);

    @InheritInverseConfiguration
    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productsToProductDtos(List<Product> products);

    @InheritInverseConfiguration
    List<Product> productDtosToProducts(List<ProductDto> productDtos);
}
