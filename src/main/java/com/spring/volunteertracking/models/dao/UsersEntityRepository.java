package com.spring.volunteertracking.models.dao;

import com.spring.volunteertracking.models.dto.UserDto;
import com.spring.volunteertracking.models.entities.UsersEntity;
import com.spring.volunteertracking.models.entities.UsersPwdEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UsersEntityRepository implements UserDao {

    private final EntityManager entityManager;

    public UsersEntityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static UsersEntity getUsersEntity(UserDto user, UsersPwdEntity usersPwdEntity) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setName(user.getName());
        usersEntity.setLocation(user.getLocation());
        usersEntity.setDateOfBirth(user.getDateOfBirth());
        usersEntity.setUsersPwdById(usersPwdEntity);
        usersEntity.setContactNumber(user.getContactNumber());
        usersEntity.setEmail(user.getEmail());
        return usersEntity;
    }

    private static UsersPwdEntity getUsersPwdEntity(UserDto user) {
        UsersPwdEntity usersPwdEntity = new UsersPwdEntity();
        usersPwdEntity.setPassword(user.getPassword());
        return usersPwdEntity;
    }

    @Override
    @Transactional
    public String registerUser(UserDto user) {
        UsersPwdEntity usersPwdEntity = getUsersPwdEntity(user);
        UsersEntity usersEntity = getUsersEntity(user, usersPwdEntity);
        entityManager.persist(usersEntity);
        return String.format("User Registered Successfully, with ID %s -> for Email ID %s", usersPwdEntity.getUserId(), usersEntity.getEmail());
    }

    @Override
    public List<UsersEntity> findAll() {
        TypedQuery<UsersEntity> typedQuery = entityManager.createQuery("FROM UsersEntity", UsersEntity.class);
        return typedQuery.getResultList();
    }
}