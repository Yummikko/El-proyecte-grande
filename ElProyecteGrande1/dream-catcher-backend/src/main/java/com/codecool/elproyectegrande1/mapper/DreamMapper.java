package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.dream.DreamDto;
import com.codecool.elproyectegrande1.dto.dream.NewDreamDto;
import com.codecool.elproyectegrande1.entity.Dream;
import org.springframework.stereotype.Component;

@Component
public class DreamMapper {
    public DreamDto mapEntityToDreamDto(Dream entity) {
        return new DreamDto(
                entity.getId(),
                entity.getDreamTitle(),
                entity.getDreamDescription(),
                entity.getHashtags(),
                entity.getImage()
        );
    }

    public Dream mapNewDreamDtoToEntity(NewDreamDto dto) {
        return new Dream(
                dto.getDreamTitle(),
                dto.getDreamDescription(),
                dto.getHashtags(),
                dto.getComments(),
                dto.getImage()
        );
    }
}