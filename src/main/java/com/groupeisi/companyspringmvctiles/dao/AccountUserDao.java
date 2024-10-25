package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.AccountUserEntity;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountUserDao extends RepositoryImpl<AccountUserEntity> implements IAccountUserDao{

    @Override
    public Optional<AccountUserEntity> login(String email, String password) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<AccountUserEntity> cr = cb.createQuery(AccountUserEntity.class);
        Root<AccountUserEntity> user = cr.from(AccountUserEntity.class);
        //Predicate pour la clause where
        Predicate predicateEmail = cb.equal(user.get("email"), email);
        Predicate predicatePwd = cb.equal(user.get("password"), password);
        Predicate finalPredicate = cb.and(predicateEmail, predicatePwd);

        cr.select(user);
        cr.where(finalPredicate);

        return Optional.ofNullable(session.createQuery(cr).getSingleResult());
    }
}
