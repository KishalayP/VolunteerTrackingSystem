package com.spring.volunteertracking.services.registration;

import com.spring.volunteertracking.models.dao.UserDao;
import com.spring.volunteertracking.models.dto.RegistrationResponseDto;
import com.spring.volunteertracking.models.dto.UserDto;
import com.spring.volunteertracking.models.entities.UsersEntity;
import org.springframework.stereotype.Service;

import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Service
public class RegisterUsersService {
    private final UserDao userDao;

    public RegisterUsersService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UsersEntity> findAll() {
        return userDao.findAll();
    }

    public RegistrationResponseDto registerUser(UserDto user) throws InvalidKeySpecException {
        return userDao.registerUser(user);
    }
}
