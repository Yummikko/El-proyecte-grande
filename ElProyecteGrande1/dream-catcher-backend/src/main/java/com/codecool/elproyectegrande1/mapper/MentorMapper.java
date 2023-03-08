package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.MentorDto;
import com.codecool.elproyectegrande1.entity.Mentor;
import org.springframework.stereotype.Component;

@Component
public class MentorMapper {

    public MentorDto mapEntityToMentorDto(Mentor entity) {
        return new MentorDto(
            entity.getId(),
            entity.getNickname(),
            entity.getEmail(),
            entity.getPassword(),
            entity.getFollowers()
        );
    }
}
