package com.spring.volunteertracking.models.dao;

import com.spring.volunteertracking.models.dto.UserDto;
import com.spring.volunteertracking.models.entities.UsersEntity;

import java.util.List;

public interface UserDao {

    String registerUser(UserDto user);

    List<UsersEntity> findAll();
}
