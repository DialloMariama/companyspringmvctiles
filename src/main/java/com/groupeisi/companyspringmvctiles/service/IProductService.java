package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<List<ProductDto>> findAll();

    boolean save(ProductDto productDto);

    Optional<ProductDto> findByRef(String ref);

    boolean update(ProductDto productDto);
}
