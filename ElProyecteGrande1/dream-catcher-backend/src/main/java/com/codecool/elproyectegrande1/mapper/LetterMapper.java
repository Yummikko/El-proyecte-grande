package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.NewLetterDto;
import com.codecool.elproyectegrande1.entity.Letter;
import org.springframework.stereotype.Component;

@Component
public class LetterMapper {

    public NewLetterDto mapEntityToNewLetterDto(Letter entity) {
        return new NewLetterDto(
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
