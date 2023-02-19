package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.SignInDto;
import com.codecool.elproyectegrande1.dto.SignInMentorDto;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.exceptions.AuthenticationFailException;
import com.codecool.elproyectegrande1.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public SignInDto signIn(SignInDto signInDto) {
        User user = userRepository.findByEmail(signInDto.getEmail());
        if (user == null) {
            throw new AuthenticationFailException("User not present");
        }
        try {
            if (!user.getPassword().equals(signInDto.getPassword())) {
                //password doesn't match
                throw new AuthenticationFailException("Wrong password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        return new SignInDto(user.getEmail(), user.getPassword(),"Login success");
    }

    public SignInMentorDto signInMentor(SignInMentorDto signInMentorDto) {
        User user = userRepository.findByEmail(signInMentorDto.getEmail());
        if (user == null) {
            throw new AuthenticationFailException("User not present");
        }
        try {
            if (!user.getPassword().equals(signInMentorDto.getPassword())) {
                //password doesn't match
                throw new AuthenticationFailException("Wrong password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        return new SignInMentorDto(user.getEmail(), user.getPassword(), "Login success");
    }

}
