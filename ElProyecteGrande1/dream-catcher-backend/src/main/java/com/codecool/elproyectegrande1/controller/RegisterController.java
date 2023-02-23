package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.SignUpDto;
import com.codecool.elproyectegrande1.dto.UserDto;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.exceptions.UserAlreadyExistException;
import com.codecool.elproyectegrande1.service.RegistrationService;
import com.codecool.elproyectegrande1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @GetMapping("/user")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto userDto,
            HttpServletRequest request,
            Errors errors) {

        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            LOGGER.debug("An account for that username/email already exists.");
        }

        return new ModelAndView("successRegister", "user", userDto);
    }

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
