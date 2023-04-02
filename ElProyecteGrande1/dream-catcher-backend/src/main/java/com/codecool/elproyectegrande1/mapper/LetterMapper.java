package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.LetterDto;
import com.codecool.elproyectegrande1.dto.NewLetterDto;
import com.codecool.elproyectegrande1.entity.Letter;
import org.springframework.stereotype.Component;

@Component
public class LetterMapper {

    public LetterDto mapEntityToLetterDto(Letter entity) {
        return new LetterDto(
                entity.getId(),
                entity.getContent(),
                entity.getDateTime(),
                entity.getSender()
        );
    }

    public Letter mapNewLetterDtoToEntity(NewLetterDto dto, String sender) {
        return new Letter(
                dto.getContent(),
                sender
        );
    }

}
