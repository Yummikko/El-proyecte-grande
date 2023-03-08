package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.DreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import org.springframework.stereotype.Component;


@Component
public class NewDreamerMapper {
    public DreamerDto mapEntityToUserDto(Dreamer entity) {
        return new DreamerDto(
                entity.getId(),
                entity.getNickname(),
                entity.getEmail(),
                entity.getFollowers(),
                entity.getUser()
        );
    }

    public Dreamer mapUserDtoToEntity(DreamerDto dto) {
        return new Dreamer(
                dto.getId(),
                dto.getNickname(),
                dto.getEmail(),
                0,
                dto.getUser()
        );
    }
}