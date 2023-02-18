package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.SignInDto;
import com.codecool.elproyectegrande1.dto.SignInMentorDto;
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

    @PostMapping("/signIn/")
    public SignInDto Signup(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }
    @PostMapping("/signIn-mentor/")
    public SignInMentorDto SignInMentor(@RequestBody SignInMentorDto signInMentorDto) {
        return userService.signInMentor(signInMentorDto);
    }

}
