package com.spring.volunteertracking.models.dao;

import com.spring.volunteertracking.models.entities.UsersEntity;
import com.spring.volunteertracking.models.entities.UsersPwdEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class UsersEntityRepository implements UserDao {

    private final EntityManager entityManager;

    public UsersEntityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void registerUser(UUID id, String name, String location, Date date, String password) {
        UsersPwdEntity usersPwdEntity = new UsersPwdEntity();
        usersPwdEntity.setUserId(id);
        usersPwdEntity.setPassword(password);
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(id);
        usersEntity.setName(name);
        usersEntity.setLocation(location);
        usersEntity.setDateOfBirth(date);
        usersEntity.setUsersPwdEntity(usersPwdEntity);
        entityManager.persist(usersEntity);
    }

    @Override
    public List<UsersEntity> findAll() {
        TypedQuery<UsersEntity> typedQuery = entityManager.createQuery("select * from users ", UsersEntity.class);
        return typedQuery.getResultList();
    }
}