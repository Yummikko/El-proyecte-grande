package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.dreamer.DreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.entity.ERole;
import com.codecool.elproyectegrande1.entity.Role;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.mapper.NewDreamerMapper;
import com.codecool.elproyectegrande1.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DreamerServiceTest {

    @Mock
    private NewDreamerMapper newDreamerMapper;

    @Mock
    private UserRepository userRepository;

    @Test
    void shouldCreateDreamer() {
    }

    @Test
    void followDreamer() {
    }

    @Test
    void getDreamerWithMostFollowers() {
    }

    @Test
    void getDreamerById() {
    }

    @Test
    void unfollowDreamer() {
    }

    @Test
    void donateDreamer() {
    }

    @Test
    void createDreamerFromUser() {
    }
}