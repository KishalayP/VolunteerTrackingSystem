package com.spring.volunteertracking.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("/login")
@Slf4j
public class LoginController {

    @PostMapping(value = "/createUser")
    @ResponseBody
    public String loginRequest(String name,String password){
        log.info("User :{}, Password:{}",name,password);
        return "User Created";
    }
}
