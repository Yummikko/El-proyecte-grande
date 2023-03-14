package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.entity.Mentor;
import com.codecool.elproyectegrande1.entity.Offer;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.mapper.MentorMapper;
import com.codecool.elproyectegrande1.mapper.OfferMapper;
import com.codecool.elproyectegrande1.repository.MentorRepository;
import com.codecool.elproyectegrande1.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;
    private final OfferRepository offerRepository;
    private final MentorMapper mentorMapper;
    private final OfferMapper offerMapper;

    @Autowired
    public MentorService(MentorRepository mentorRepository, OfferRepository offerRepository, MentorMapper mentorMapper, OfferMapper offerMapper) {
        this.mentorRepository = mentorRepository;
        this.offerRepository = offerRepository;
        this.mentorMapper = mentorMapper;
        this.offerMapper = offerMapper;
    }

    public OfferDto addOffer(Long id, OfferDto offerDto) {
        Mentor mentor = mentorRepository.findById(id).orElseThrow();

        Offer offer = offerMapper.mapOfferDtoToEntity(offerDto);
        offer.setMentor(mentor);
        Offer savedOffer = offerRepository.save(offer);

        mentor.getOffers().add(savedOffer);
        mentorRepository.save(mentor);

        return offerMapper.mapEntityToOfferDto(savedOffer);
    }

    public void createMentorFromUser(User user) {
        Mentor mentor = mentorMapper.mapUserToMentor(user);
        mentorRepository.save(mentor);
    }

}
