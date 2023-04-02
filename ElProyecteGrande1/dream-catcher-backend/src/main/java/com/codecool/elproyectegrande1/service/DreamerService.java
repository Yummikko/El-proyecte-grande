package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.DreamerDto;
import com.codecool.elproyectegrande1.dto.NewDreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.mapper.NewDreamerMapper;
import com.codecool.elproyectegrande1.repository.DreamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DreamerService {

    private final DreamerRepository dreamerRepository;
    private final NewDreamerMapper dreamerMapper;

    @Autowired
    public DreamerService(DreamerRepository dreamerRepository, NewDreamerMapper dreamerMapper) {
        this.dreamerRepository = dreamerRepository;
        this.dreamerMapper = dreamerMapper;
    }

    public DreamerDto createDreamer(NewDreamerDto newDreamerDto) {
        Dreamer dreamer = dreamerMapper.mapNewDreamerDtoToEntity(newDreamerDto);
        Dreamer savedDreamer = dreamerRepository.save(dreamer);
        return dreamerMapper.mapEntityToDreamerDto(savedDreamer);
    }

    public void followDreamer(Long dreamerId) {
        Dreamer dreamer = dreamerRepository.findById(dreamerId).orElseThrow();
        dreamer.setFollowers(dreamer.getFollowers() + 1);
        dreamerRepository.save(dreamer);
    }

    public Dreamer getDreamerWithMostFollowers() {
        return dreamerRepository.findTopByOrderByFollowersDesc();
    }

    public DreamerDto getDreamerById(Long id) {
        Dreamer dreamer = dreamerRepository.findById(id).orElseThrow();
        return dreamerMapper.mapEntityToDreamerDto(dreamer);
    }

    public void unfollowDreamer(Long dreamerId) {
        Dreamer dreamer = dreamerRepository.findById(dreamerId).orElseThrow();
        dreamer.setFollowers(dreamer.getFollowers() - 1);
        dreamerRepository.save(dreamer);
    }

    public void donateDreamer(Long dreamerId, BigDecimal amount) {
        Dreamer dreamer = dreamerRepository.findById(dreamerId).orElseThrow();
        dreamer.setFunds(amount);
        dreamerRepository.save(dreamer);
    }

    public void createDreamerFromUser(User user) {
        Dreamer dreamer = dreamerMapper.mapUserToDreamer(user);
        dreamerRepository.save(dreamer);
    }
}
