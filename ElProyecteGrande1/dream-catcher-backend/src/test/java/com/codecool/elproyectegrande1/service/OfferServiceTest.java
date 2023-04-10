package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.entity.Offer;
import com.codecool.elproyectegrande1.mapper.OfferMapper;
import com.codecool.elproyectegrande1.repository.OfferRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OfferServiceTest {

    @InjectMocks
    private OfferService offerService;

    @Mock
    private OfferRepository offerRepository;

    @Mock
    private OfferMapper offerMapper;

    @Test
    public void testGetAllOffers() {
        Offer offer1 = new Offer();
        Offer offer2 = new Offer();
        List<Offer> offers = Arrays.asList(offer1, offer2);

        OfferDto offerDto1 = new OfferDto();
        OfferDto offerDto2 = new OfferDto();
        List<OfferDto> offerDtos = Arrays.asList(offerDto1, offerDto2);

        when(offerRepository.findAll()).thenReturn(offers);
        when(offerMapper.mapEntityToOfferDto(offer1)).thenReturn(offerDto1);
        when(offerMapper.mapEntityToOfferDto(offer2)).thenReturn(offerDto2);

        List<OfferDto> result = offerService.getAllOffers();

        assertEquals(offerDtos, result);
    }
}