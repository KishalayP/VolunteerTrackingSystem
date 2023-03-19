package com.spring.volunteertracking.models.dao;

import com.spring.volunteertracking.models.dto.RegistrationResponseDto;
import com.spring.volunteertracking.models.dto.UserDto;
import com.spring.volunteertracking.models.entities.UsersEntity;
import com.spring.volunteertracking.models.entities.UsersPwdEntity;
import com.spring.volunteertracking.services.encryption.PasswordManagementService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UsersEntityRepository implements UserDao {

    private final EntityManager entityManager;
    private final PasswordManagementService passwordManagementService;

    public UsersEntityRepository(EntityManager entityManager, PasswordManagementService passwordManagementService) {
        this.entityManager = entityManager;
        this.passwordManagementService = passwordManagementService;
    }

    private UsersEntity getUsersEntity(UserDto user, UsersPwdEntity usersPwdEntity) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setName(user.getName());
        usersEntity.setLocation(user.getLocation());
        usersEntity.setDateOfBirth(user.getDateOfBirth());
        usersEntity.setUsersPwdById(usersPwdEntity);
        usersEntity.setContactNumber(user.getContactNumber());
        usersEntity.setEmail(user.getEmail());
        return usersEntity;
    }

    private UsersPwdEntity getUsersPwdEntity(UserDto user) {
        UsersPwdEntity usersPwdEntity = new UsersPwdEntity();
        String hashPassword = passwordManagementService.hashPassword(user.getPassword());
        usersPwdEntity.setPassword(hashPassword);
        return usersPwdEntity;
    }

    @Override
    @Transactional
    public RegistrationResponseDto registerUser(UserDto user) {
        UsersPwdEntity usersPwdEntity = getUsersPwdEntity(user);
        UsersEntity usersEntity = getUsersEntity(user, usersPwdEntity);
        entityManager.persist(usersEntity);
        return new RegistrationResponseDto(usersPwdEntity.getUserId(), "User Registered Successfully", usersEntity.getEmail(), usersEntity.getName());
    }

    @Override
    public List<UsersEntity> findAll() {
        TypedQuery<UsersEntity> typedQuery = entityManager.createQuery("FROM UsersEntity", UsersEntity.class);
        return typedQuery.getResultList();
    }
}