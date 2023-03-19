package com.spring.volunteertracking.models.dao;

import com.spring.volunteertracking.models.dto.RegistrationResponseDto;
import com.spring.volunteertracking.models.dto.UserDto;
import com.spring.volunteertracking.models.entities.UsersEntity;

import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface UserDao {

    RegistrationResponseDto registerUser(UserDto user) throws InvalidKeySpecException;

    List<UsersEntity> findAll();
}
