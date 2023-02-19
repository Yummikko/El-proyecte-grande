package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.SignUpDto;
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
    private RegistrationService registrationService;

    @PostMapping("/dreamer")
    public ResponseEntity<?> register(@RequestBody SignUpDto signUpDto) {
        try {
            registrationService.register(signUpDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while registering user: " + e.getMessage());
        }
    }

    @PostMapping("/mentor")
    public ResponseEntity<?> registerMentor(@RequestBody SignUpDto signUpDto) {
        try {
            registrationService.registerMentor(signUpDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while registering user: " + e.getMessage());
        }
    }
}
