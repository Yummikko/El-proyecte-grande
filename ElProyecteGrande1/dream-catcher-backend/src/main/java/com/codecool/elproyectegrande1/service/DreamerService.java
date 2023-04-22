package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.dream.DreamDto;
import com.codecool.elproyectegrande1.dto.dreamer.DreamerDto;
import com.codecool.elproyectegrande1.dto.dreamer.NewDreamerDto;
import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.mapper.DreamMapper;
import com.codecool.elproyectegrande1.mapper.NewDreamerMapper;
import com.codecool.elproyectegrande1.repository.DreamRepository;
import com.codecool.elproyectegrande1.repository.DreamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DreamerService {

    private final DreamerRepository dreamerRepository;
    private final DreamRepository dreamRepository;
    private final NewDreamerMapper dreamerMapper;
    private final DreamMapper dreamMapper;

    @Autowired
    public DreamerService(DreamerRepository dreamerRepository, DreamRepository dreamRepository, NewDreamerMapper dreamerMapper, DreamMapper dreamMapper) {
        this.dreamerRepository = dreamerRepository;
        this.dreamRepository = dreamRepository;
        this.dreamerMapper = dreamerMapper;
        this.dreamMapper = dreamMapper;
    }

    public DreamerDto createDreamer(NewDreamerDto newDreamerDto) {
        Dreamer dreamer = dreamerMapper.mapNewDreamerDtoToEntity(newDreamerDto);
        Dreamer savedDreamer = dreamerRepository.save(dreamer);
        return dreamerMapper.mapEntityToDreamerDto(savedDreamer);
    }

    public void followDreamer(Long dreamerId) {
        Dreamer dreamer = dreamerRepository.findById(dreamerId)
                .orElseThrow(() -> new IllegalArgumentException("Dreamer with id " + dreamerId + " not found"));
        dreamer.setFollowers(dreamer.getFollowers() + 1);
        dreamerRepository.save(dreamer);
    }

    public Dreamer getDreamerWithMostFollowers() {
        return dreamerRepository.findTopByOrderByFollowersDesc();
    }

    public DreamerDto getDreamerByNickname(String nickname) {
        Dreamer dreamer = dreamerRepository.findByNickname(nickname)
                .orElseThrow(() -> new IllegalArgumentException("Dreamer with id " + nickname + " not found"));
        System.out.println(dreamer.getNickname());
        return dreamerMapper.mapEntityToDreamerDto(dreamer);
    }

    public void unfollowDreamer(Long dreamerId) {
        Dreamer dreamer = dreamerRepository.findById(dreamerId)
                .orElseThrow(() -> new IllegalArgumentException("Dreamer with id " + dreamerId + " not found"));
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

    public List<DreamDto> getAllDreamsByDreamerNickname(String nickname) {
        List<Dream> dreams = dreamRepository.findByDreamerNickname(nickname);

        List<DreamDto> dreamDtos = new ArrayList<>();

        for (int i = 0; i < 8 && i < dreams.size(); i++) {
            DreamDto dto = dreamMapper.mapEntityToDreamDto(dreams.get(i));
            dreamDtos.add(dto);
        }

        return dreamDtos;
    }
}
