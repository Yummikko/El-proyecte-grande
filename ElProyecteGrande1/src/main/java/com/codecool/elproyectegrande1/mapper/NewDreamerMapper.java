package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.UserDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import org.springframework.stereotype.Component;


@Component
public class NewDreamerMapper {
    public UserDto mapEntityToUserDto(Dreamer entity) {
        return new UserDto(
                entity.getId(),
                entity.getNickname(),
                entity.getEmail(),
                entity.getPassword()
        );
    }

    public Dreamer mapUserDtoToEntity(UserDto dto) {
        return new Dreamer(
                dto.getId(),
                dto.getNickname(),
                dto.getEmail(),
                dto.getPassword()
        );
    }
}