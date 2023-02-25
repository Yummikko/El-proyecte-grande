package com.codecool.elproyectegrande1.service;


import com.codecool.elproyectegrande1.dto.SignUpDto;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public void register(SignUpDto signUpDto) {
        User user = new User();
        userRepository.save(user);
    }

    public void registerMentor(SignUpDto signUpDto) {
        User user = new User();
        userRepository.save(user);
    }
}