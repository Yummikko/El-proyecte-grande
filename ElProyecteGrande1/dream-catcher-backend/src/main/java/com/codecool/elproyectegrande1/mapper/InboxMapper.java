package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.InboxDto;
import com.codecool.elproyectegrande1.dto.NewLetterDto;
import com.codecool.elproyectegrande1.entity.Inbox;
import org.springframework.stereotype.Component;

@Component
public class InboxMapper {

    public InboxDto mapEntityToInboxDto(Inbox entity) {
        return new InboxDto(
                entity.getId(),
                entity.getLetters(),
                entity.getUser()
        );
    }

    public Inbox mapNewLetterDtoToEntity(NewLetterDto dto) {
        return new Inbox(
                dto.getId()
        );
    }
}
