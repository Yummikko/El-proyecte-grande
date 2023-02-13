package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.SignInDto;
import com.codecool.elproyectegrande1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    UserService userService;

    //#1: check if the login data provided through the end point is correct
    //#2: if yes then create a session for username
    //#3: need to hash password
    @PostMapping("/signIn/")
    public SignInDto Signup(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }

}
