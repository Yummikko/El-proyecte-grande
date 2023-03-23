package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.DreamDto;
import com.codecool.elproyectegrande1.dto.NewDreamDto;
import com.codecool.elproyectegrande1.entity.Dream;
import org.springframework.stereotype.Component;

@Component
public class DreamMapper {
    public DreamDto mapEntityToDreamDto(Dream entity) {
        return new DreamDto(
                entity.getId(),
                entity.getDreamTitle(),
                entity.getDreamDescription(),
                entity.getLikes(),
                entity.getViews(),
                entity.getDreamStatus(),
                entity.getHashtags(),
                entity.getComments(),
                entity.getPhotos()
        );
    }

    public Dream mapNewDreamDtoToEntity(NewDreamDto dto) {
        return new Dream(
                dto.getDreamTitle(),
                dto.getDreamDescription(),
                0,
                0,
                dto.getHashtags(),
                dto.getComments(),
                dto.getPhotos());
    }
}