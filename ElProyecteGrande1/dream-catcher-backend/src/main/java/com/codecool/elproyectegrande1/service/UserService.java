package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.SignInDto;
import com.codecool.elproyectegrande1.dto.SignInMentorDto;
import com.codecool.elproyectegrande1.dto.UserDto;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.exceptions.AuthenticationFailException;
import com.codecool.elproyectegrande1.exceptions.UserAlreadyExistException;
import com.codecool.elproyectegrande1.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        List roles = new ArrayList<>();
        roles.add("mentor");
        roles.add("dreamer");
        user.setRoles(roles);

        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

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
