package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.config.HibernateUtil;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.Optional;

@Repository
public class ClientDao extends RepositoryImpl<ClientEntity> implements IClientDao{
    @Override
    public Optional<ClientEntity> findByEmail(String email) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ClientEntity> cr = cb.createQuery(ClientEntity.class);
        Root<ClientEntity> client = cr.from(ClientEntity.class);
        Predicate predicateEmail = cb.equal(client.get("email"), email);
        cr.select(client).where(predicateEmail);

        try {
            return Optional.ofNullable(session.createQuery(cr).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean update(ClientEntity clientEntity) {
        session.getTransaction().begin();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<ClientEntity> update = cb.createCriteriaUpdate(ClientEntity.class);
        Root<ClientEntity> client = update.from(ClientEntity.class);

        update.set("firstname", clientEntity.getFirstName());
        update.set("lastname", clientEntity.getLastName());
        update.set("email", clientEntity.getEmail());
        update.set("address", clientEntity.getAddress());
        update.set("tel", clientEntity.getTel());

        Predicate predicateEmail = cb.equal(client.get("email"), clientEntity.getEmail());
        update.where(predicateEmail);

        int rowsAffected = session.createQuery(update).executeUpdate();

        session.getTransaction().commit();

        return rowsAffected > 0;
    }

    @Override
    public Optional<ClientEntity> findById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            return Optional.ofNullable(session.get(ClientEntity.class, id));
        } finally {
            session.close();
        }
    }
}
