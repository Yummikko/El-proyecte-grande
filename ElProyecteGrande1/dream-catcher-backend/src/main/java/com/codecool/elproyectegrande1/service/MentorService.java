package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.offer.NewOfferDto;
import com.codecool.elproyectegrande1.dto.offer.OfferDto;
import com.codecool.elproyectegrande1.entity.Mentor;
import com.codecool.elproyectegrande1.entity.Offer;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.mapper.MentorMapper;
import com.codecool.elproyectegrande1.mapper.OfferMapper;
import com.codecool.elproyectegrande1.repository.ImageRepository;
import com.codecool.elproyectegrande1.repository.MentorRepository;
import com.codecool.elproyectegrande1.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;
    private final OfferRepository offerRepository;
    private final MentorMapper mentorMapper;
    private final OfferMapper offerMapper;
    private final ImageRepository imageRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository, OfferRepository offerRepository, MentorMapper mentorMapper, OfferMapper offerMapper, ImageRepository imageRepository) {
        this.mentorRepository = mentorRepository;
        this.offerRepository = offerRepository;
        this.mentorMapper = mentorMapper;
        this.offerMapper = offerMapper;
        this.imageRepository = imageRepository;
    }

    public OfferDto addOffer(String name, NewOfferDto offerDto) {
        Mentor mentor = mentorRepository.findByNickname(name)
                .orElseThrow(() -> new IllegalArgumentException("Mentor with nickname " + name + " not found"));

        Offer offer = offerMapper.mapOfferDtoToEntity(offerDto);
        offer.setMentor(mentor);

        Offer savedOffer = offerRepository.save(offer);

        List<Offer> updatedOffers = mentor.getOffers();
        updatedOffers.add(savedOffer);
//        mentorRepository.updateOffers(mentor.getId(), updatedOffers);
        mentorRepository.save(mentor);

        return offerMapper.mapEntityToOfferDto(savedOffer);
    }

    public void createMentorFromUser(User user) {
        Mentor mentor = mentorMapper.mapUserToMentor(user);
        mentorRepository.save(mentor);
    }

}
