package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.DreamerDto;
import com.codecool.elproyectegrande1.dto.NewDreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import org.springframework.stereotype.Component;


@Component
public class NewDreamerMapper {
    public DreamerDto mapEntityToDreamerDto(Dreamer entity) {
        return new DreamerDto(
                entity.getId(),
                entity.getNickname(),
                entity.getEmail(),
                entity.getFollowers(),
                entity.getUser()
        );
    }

    public Dreamer mapDreamerDtoToEntity(DreamerDto dto) {
        return new Dreamer(
                dto.getNickname(),
                dto.getEmail()
        );
    }

    public Dreamer mapNewDreamerDtoToEntity(NewDreamerDto dto) {
        return new Dreamer(dto.getNickname(), dto.getEmail());
    }
}