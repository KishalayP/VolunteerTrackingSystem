package com.spring.volunteertracking.controller;

import com.spring.volunteertracking.models.dto.RegistrationResponseDto;
import com.spring.volunteertracking.models.dto.UserDto;
import com.spring.volunteertracking.models.entities.UsersEntity;
import com.spring.volunteertracking.services.registration.RegisterUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller("/registration")
@Slf4j
public class RegistrationController {

    private final RegisterUsersService registerUsersService;

    public RegistrationController(RegisterUsersService registerUser) {
        this.registerUsersService = registerUser;
    }

    @PostMapping(value = "/createUser")
    @ResponseBody
    public EntityModel<RegistrationResponseDto> registerUser(@Valid @RequestBody UserDto user) throws InvalidKeySpecException {
        log.info("Creating User :{}", user.getName());
        Link link = linkTo(methodOn(RegistrationController.class).findAll()).withRel("findAll");
        return EntityModel.of(registerUsersService.registerUser(user), link);
    }

    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<UsersEntity> findAll() {
        return registerUsersService.findAll();
    }
}
