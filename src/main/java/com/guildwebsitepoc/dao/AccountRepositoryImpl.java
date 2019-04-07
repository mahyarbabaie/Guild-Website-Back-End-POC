package com.guildwebsitepoc.dao;

import com.guildwebsitepoc.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AccountRepositoryImpl implements AccountRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Account> findByUsername(String username) {
        Query query = entityManager.createNativeQuery("SELECT * FROM guild_website_poc_app.accounts " +
                "WHERE username = :user", Account.class);
        System.out.println("Username: " + username);
        query.setParameter("user", username);
        return query.getResultList();
    }
}
