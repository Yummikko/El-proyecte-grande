package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegistrationService userService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody String password) {
        String encryptedPassword = userService.encryptPassword(password);
        Dreamer dreamer = new Dreamer(encryptedPassword);
        try {
            userService.register(dreamer);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while registering user: " + e.getMessage());
        }
    }
}
