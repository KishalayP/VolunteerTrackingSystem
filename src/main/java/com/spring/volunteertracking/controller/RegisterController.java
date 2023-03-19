package com.spring.volunteertracking.controller;

import com.spring.volunteertracking.models.dao.UserDao;
import com.spring.volunteertracking.models.dto.UserDto;
import com.spring.volunteertracking.models.entities.UsersEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller("/registration")
@Slf4j
public class RegisterController {

    private final UserDao usersEntityRepository;

    public RegisterController(UserDao usersEntityRepository) {
        this.usersEntityRepository = usersEntityRepository;
    }

    @PostMapping(value = "/createUser")
    @ResponseBody
    public String registerUser(@RequestBody UserDto user) {
        log.info("Creating User :{}", user.getName());
        UUID id = UUID.randomUUID();
        usersEntityRepository.registerUser(user.getId(), user.getName(), user.getLocation(), user.getDateOfBirth(), user.getPassword());
        List<UsersEntity> all = usersEntityRepository.findAll();
        log.info(all.toString());
        return "User Created with ID:" + id;
    }
}
