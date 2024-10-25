package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.AccountUserDto;
import com.groupeisi.companyspringmvctiles.entities.AccountUserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AccountUserMapper {

    private AccountUserMapper() {
    }

    public static AccountUserEntity toAccountUserEntity(AccountUserDto accountUserDto) {

        AccountUserEntity accountUserEntity = new AccountUserEntity();

        accountUserEntity.setId(accountUserDto.getId());
        accountUserEntity.setEmail(accountUserDto.getEmail());
        accountUserEntity.setPassword(accountUserDto.getPassword());
        accountUserEntity.setState(accountUserDto.isState());

        return accountUserEntity;
    }

    public static AccountUserDto toAccountUserDto(AccountUserEntity accountUserEntity) {

        AccountUserDto accountUserDto = new AccountUserDto();

        accountUserDto.setId(accountUserEntity.getId());
        accountUserDto.setEmail(accountUserEntity.getEmail());
        accountUserDto.setPassword(accountUserEntity.getPassword());
        accountUserDto.setState(accountUserEntity.isState());

        return accountUserDto;
    }

    public static List<AccountUserDto> toListAccountUserDto(List<AccountUserEntity> accountUserEntities) {
        return accountUserEntities.stream()
                .map(AccountUserMapper::toAccountUserDto)
                .collect(Collectors.toList());
    }
}
