package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dao.AccountUserDao;
import com.groupeisi.companyspringmvctiles.dao.IAccountUserDao;
import com.groupeisi.companyspringmvctiles.dto.AccountUserDto;
import com.groupeisi.companyspringmvctiles.entities.AccountUserEntity;
import com.groupeisi.companyspringmvctiles.mapper.AccountUserMapper;

import java.util.List;
import java.util.Optional;

public class AccountUserService implements IAccountUserService{

    private IAccountUserDao accountUserDao = new AccountUserDao();

    @Override
    public Optional<AccountUserDto> login(String email, String password) {

        if(email.isBlank() || password.isBlank()) {
            return Optional.empty();
        }
        else {
            return testLogin(email, password);
        }
    }

    private Optional<AccountUserDto> testLogin(String email, String password) {

        return	accountUserDao.login(email, password)
                .map(user -> Optional.of(AccountUserMapper.toAccountUserDto(user)))
                .orElse(Optional.empty());
    }

    @Override
    public Optional<List<AccountUserDto>> findAll() {
        List<AccountUserEntity> accountUserEntityList = accountUserDao.list(new AccountUserEntity());

        return Optional.of(AccountUserMapper.toListAccountUserDto(accountUserEntityList));
    }

    public void setAccountUserDao(IAccountUserDao accountUserDao) {
        this.accountUserDao = accountUserDao;
    }

    @Override
    public boolean save(AccountUserDto accountUserDto) {
        return accountUserDao.save(AccountUserMapper.toAccountUserEntity(accountUserDto));
    }
}
