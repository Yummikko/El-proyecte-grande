package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.letter.LetterDto;
import com.codecool.elproyectegrande1.dto.letter.NewLetterDto;;
import com.codecool.elproyectegrande1.entity.Letter;
import com.codecool.elproyectegrande1.mapper.LetterMapper;
import com.codecool.elproyectegrande1.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {

    private final LetterRepository letterRepository;
    private final LetterMapper letterMapper;

    @Autowired
    public LetterService(LetterRepository letterRepository, LetterMapper letterMapper) {
        this.letterRepository = letterRepository;
        this.letterMapper = letterMapper;
    }

    public List<Letter> getAllLetters() {
        return letterRepository.findAll();
    }

    public Letter getLetterById(Long id) {
        return letterRepository.findById(id).orElse(null);
    }

    public LetterDto addLetter(String sender, NewLetterDto newLetterDto) {
        Letter toBeSaved = letterMapper.mapNewLetterDtoToEntity(newLetterDto, sender);
        Letter savedLetter = letterRepository.save(toBeSaved);
        return letterMapper.mapEntityToLetterDto(savedLetter);
    }

    public void deleteLetterById(Long id) {
        letterRepository.deleteById(id);
    }
}
