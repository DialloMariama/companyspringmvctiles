package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class ProductDao extends RepositoryImpl<ProductEntity> implements IProductDao {

    @Override
    public Optional<ProductEntity> findByRef(String ref) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> cr = cb.createQuery(ProductEntity.class);
        Root<ProductEntity> product = cr.from(ProductEntity.class);

        Predicate predicateRef = cb.equal(product.get("ref"), ref);

        cr.select(product).where(predicateRef);

        try {
            return Optional.ofNullable(session.createQuery(cr).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean update(ProductEntity productEntity) {
        session.getTransaction().begin();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<ProductEntity> update = cb.createCriteriaUpdate(ProductEntity.class);
        Root<ProductEntity> product = update.from(ProductEntity.class);

        update.set("name", productEntity.getName());
        update.set("stock", productEntity.getStock());

        Predicate predicateRef = cb.equal(product.get("ref"), productEntity.getRef());
        update.where(predicateRef);

        int rowsAffected = session.createQuery(update).executeUpdate();

        session.getTransaction().commit();

        return rowsAffected > 0;
    }
}
