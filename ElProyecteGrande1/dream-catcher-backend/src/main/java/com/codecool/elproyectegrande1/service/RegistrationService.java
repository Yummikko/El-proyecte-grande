package com.codecool.elproyectegrande1.service;


import com.codecool.elproyectegrande1.dto.SignUpDto;
import com.codecool.elproyectegrande1.entity.Role;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.repository.UserRepository;
import com.codecool.elproyectegrande1.util.PassBasedEnc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    
    @Autowired
    private UserRepository userRepository;

    public void register(SignUpDto signUpDto) {
        String encryptedPassword = encryptPassword(signUpDto.getPassword());
        User user = new User(signUpDto.getFirstName(), encryptedPassword, signUpDto.getEmail(), Role.DREAMER);
        userRepository.save(user);
    }

    public void registerMentor(SignUpDto signUpDto) {
        String encryptedPassword = encryptPassword(signUpDto.getPassword());
        User user = new User(signUpDto.getFirstName(), encryptedPassword, signUpDto.getEmail(), Role.MENTOR);
        userRepository.save(user);
    }

    public String encryptPassword(String password) {
        PassBasedEnc passBasedEnc = new PassBasedEnc();
        String saltValue = passBasedEnc.getSaltvalue(30);
        String encryptedPassword = passBasedEnc.generateSecurePassword(password, saltValue);
        return encryptedPassword;
    }
}