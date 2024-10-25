package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dto.AccountUserDto;

import java.util.List;
import java.util.Optional;

public interface IAccountUserService {
    Optional<AccountUserDto> login(String email, String password);

    Optional<List<AccountUserDto>> findAll();

    boolean save(AccountUserDto accountUserDto);
}
