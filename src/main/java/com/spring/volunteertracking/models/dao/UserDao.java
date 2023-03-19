package com.spring.volunteertracking.models.dao;

import com.spring.volunteertracking.models.entities.UsersEntity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface UserDao {

    void registerUser(UUID id, String name, String location, Date date, String password);

    List<UsersEntity> findAll();
}
