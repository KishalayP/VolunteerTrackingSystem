package com.spring.volunteertracking.controller;

import com.spring.volunteertracking.models.dto.UserDto;
import com.spring.volunteertracking.models.entities.UsersEntity;
import com.spring.volunteertracking.services.registration.RegisterUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/registration")
@Slf4j
public class RegistrationController {

    private final RegisterUsersService registerUsersService;

    public RegistrationController(RegisterUsersService registerUser) {
        this.registerUsersService = registerUser;
    }

    @PostMapping(value = "/createUser")
    @ResponseBody
    public String registerUser(@RequestBody UserDto user) {
        log.info("Creating User :{}", user.getName());
        return registerUsersService.registerUser(user);
    }

    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<UsersEntity> findAll() {
        return registerUsersService.findAll();
    }
}
