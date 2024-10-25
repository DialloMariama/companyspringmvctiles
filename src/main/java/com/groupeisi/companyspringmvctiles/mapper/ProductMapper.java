package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    private ProductMapper() {
    }

    public static ProductEntity toProductEntity(ProductDto productDto) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setRef(productDto.getRef());
        productEntity.setName(productDto.getName());
        productEntity.setStock(productDto.getStock());

        return productEntity;
    }

    public static ProductDto toProductDto(ProductEntity productEntity) {

        ProductDto productDto = new ProductDto();

        productDto.setRef(productEntity.getRef());
        productDto.setName(productEntity.getName());
        productDto.setStock(productEntity.getStock());

        return productDto;
    }

    public static List<ProductDto> toListProductDto(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }

    public static List<ProductEntity> toListProductEntity(List<ProductDto> productDtos) {
        return productDtos.stream()
                .map(ProductMapper::toProductEntity)
                .collect(Collectors.toList());
    }
}
