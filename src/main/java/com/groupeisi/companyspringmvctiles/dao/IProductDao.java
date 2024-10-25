package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import java.util.Optional;


public interface IProductDao extends Repository<ProductEntity> {

    Optional<ProductEntity> findByRef(String ref);

    boolean update(ProductEntity productEntity);
}
