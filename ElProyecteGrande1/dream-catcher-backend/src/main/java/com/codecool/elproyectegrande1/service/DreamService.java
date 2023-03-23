package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.DreamDto;
import com.codecool.elproyectegrande1.dto.NewDreamDto;
import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.entity.DreamStatus;
import com.codecool.elproyectegrande1.mapper.DreamMapper;
import com.codecool.elproyectegrande1.repository.DreamRepository;
import com.codecool.elproyectegrande1.repository.DreamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DreamService {

    private final DreamRepository dreamRepository;
    private final DreamMapper dreamMapper;
    private final DreamerRepository dreamerRepository;
    private final List<Dream> dreams = new ArrayList<>();


    @Autowired
    public DreamService(DreamRepository dreamRepository, DreamMapper dreamMapper, DreamerRepository dreamerRepository) {
        this.dreamRepository = dreamRepository;
        this.dreamMapper = dreamMapper;
        this.dreamerRepository = dreamerRepository;
    }

    public DreamDto addDream(NewDreamDto newDream) {
        Dream toBeSaved = dreamMapper.mapNewDreamDtoToEntity(newDream);
        Dream savedDream = dreamRepository.save(toBeSaved);
        dreams.add(savedDream);
        return dreamMapper.mapEntityToDreamDto(savedDream);
    }

    public void likeDream(Long dreamId) {
        Dream dream = dreamRepository.findById(dreamId).orElseThrow();
        dream.setLikes(dream.getLikes() + 1);
        dreamRepository.save(dream);
    }


    public List<DreamDto> getAllDreams() {
        List<Dream> dreams = dreamRepository.findAll();
        return dreams.stream()
                .map(dreamMapper::mapEntityToDreamDto)
                .collect(Collectors.toList());
    }


    public List<DreamDto> getLastSixDreams() {
        List<Dream> dreams = dreamRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<DreamDto> dreamDtos = new ArrayList<>();

        for (int i = 0; i < 6 && i < dreams.size(); i++) {
            DreamDto dto = dreamMapper.mapEntityToDreamDto(dreams.get(i));
            dreamDtos.add(dto);
        }

        return dreamDtos;
    }

    public Dream getDreamWithMostLikes() {
        return dreamRepository.findTopByOrderByLikesDesc();
    }

    public Dream getDreamWithMostViews() {
        return dreamRepository.findTopByOrderByViewsDesc();
    }

    public DreamDto getDreamById(Long id) {
        Dream dream = dreamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dream not found"));
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

    public List<DreamDto> searchDreamsByHashtag(String hashtag) {
        List<Dream> dreams = dreamRepository.findByHashtagsContaining(hashtag);
        List<DreamDto> dreamDtos = new ArrayList<>();
        for (Dream dream : dreams) {
            DreamDto dreamDto = dreamMapper.mapEntityToDreamDto(dream);
            dreamDtos.add(dreamDto);
        }
        return dreamDtos;
    }

    public void deleteDreamById(Long id) {
        dreamRepository.deleteById(id);
    }

}
