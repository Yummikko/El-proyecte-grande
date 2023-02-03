package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.DreamDto;
import com.codecool.elproyectegrande1.dto.NewDreamDto;
import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.entity.DreamStatus;
import com.codecool.elproyectegrande1.mapper.DreamMapper;
import com.codecool.elproyectegrande1.repository.DreamRepository;
import com.codecool.elproyectegrande1.repository.DreamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DreamService {

    private final DreamRepository dreamRepository;
    private final DreamMapper dreamMapper;
    private final DreamerRepository dreamerRepository;


    @Autowired
    public DreamService(DreamRepository dreamRepository, DreamMapper dreamMapper, DreamerRepository dreamerRepository) {
        this.dreamRepository = dreamRepository;
        this.dreamMapper = dreamMapper;
        this.dreamerRepository = dreamerRepository;
    }

    public DreamDto addDream(NewDreamDto newDream) {
        Dream toBeSaved = dreamMapper.mapNewDreamDtoToEntity(newDream);
        Dream savedDream = dreamRepository.save(toBeSaved);
        return dreamMapper.mapEntityToDreamDto(savedDream);
    }

    public void likeDream(Long dreamId) {
        Dream dream = dreamRepository.findById(dreamId).orElseThrow();
        dream.setLikes(dream.getLikes() + 1);
        dreamRepository.save(dream);
    }


    public Dream getDreamWithMostLikes() {
        return dreamRepository.findTopByOrderByLikesDesc();
    }

    public DreamDto getDreamById(Long id) {
        Dream dream = dreamRepository.findById(id).orElseThrow();
        return dreamMapper.mapEntityToDreamDto(dream);
    }

    public void updateDreamStatus(Long id, String status) {
        Dream dream = dreamRepository.findById(id).orElseThrow();
        dream.setDreamStatus(DreamStatus.valueOf(status.toUpperCase()));
        dreamRepository.save(dream);
    }

    public void viewsDream(Long dreamId) {
        Dream dream = dreamRepository.findById(dreamId).orElseThrow();
        dream.setViews(dream.getViews() + 1);
        dreamRepository.save(dream);
    }

    public void updateDream(Long id, String title, String description, String status) {
        Dream dream = dreamRepository.findById(id).orElseThrow();
        dream.setDreamTitle(title);
        dream.setDreamDescription(description);
        dream.setDreamStatus(DreamStatus.valueOf(status.toUpperCase()));
        dreamRepository.save(dream);
    }
}
