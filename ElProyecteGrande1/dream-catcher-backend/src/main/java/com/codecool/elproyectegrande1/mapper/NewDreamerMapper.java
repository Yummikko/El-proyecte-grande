package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.DreamerDto;
import com.codecool.elproyectegrande1.dto.NewDreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.entity.User;
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
                dto.getEmail(),
                dto.getUser()
        );
    }

    public Dreamer mapNewDreamerDtoToEntity(NewDreamerDto dto) {
        return new Dreamer(dto.getNickname(), dto.getEmail(), dto.getUser());
    }

    public Dreamer mapUserToDreamer(User user) {
        return new Dreamer(
                user.getUsername(),
                user.getEmail(),
                user
        );
    }
}