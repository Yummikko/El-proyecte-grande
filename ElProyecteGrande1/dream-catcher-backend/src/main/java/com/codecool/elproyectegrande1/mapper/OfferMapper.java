package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.NewOfferDto;
import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.entity.Offer;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {

    public OfferDto mapEntityToOfferDto(Offer entity) {
        return new OfferDto(
                entity.getType(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getDate(),
                entity.getImage(),
                entity.getLikes()
        );
    }

    public Offer mapOfferDtoToEntity(NewOfferDto dto) {
        return new Offer(
                dto.getType(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getDate(),
                dto.getImage(),
                dto.getLikes()
        );
    }
}
