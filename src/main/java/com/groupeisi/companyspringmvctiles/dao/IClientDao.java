package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.ClientEntity;

import java.util.Optional;

public interface IClientDao extends Repository<ClientEntity>{
    Optional<ClientEntity> findByEmail(String email);
    Optional<ClientEntity> findById(Long id);
    boolean update(ClientEntity clientEntity);
}
