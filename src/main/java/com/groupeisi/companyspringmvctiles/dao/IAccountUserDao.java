package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.AccountUserEntity;

import java.util.Optional;

public interface IAccountUserDao extends Repository<AccountUserEntity>{
    Optional<AccountUserEntity> login(String email, String password);
}
