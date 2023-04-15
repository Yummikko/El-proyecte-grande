package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.offer.NewOfferDto;
import com.codecool.elproyectegrande1.dto.offer.OfferDto;
import com.codecool.elproyectegrande1.entity.Image;
import com.codecool.elproyectegrande1.service.ImageService;
import com.codecool.elproyectegrande1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/mentors")
public class MentorController {

    private final MentorService mentorService;
    private final ImageService imageService;
    private boolean isLoggedIn = false;

    @Autowired
    public MentorController(MentorService mentorService, ImageService imageService) {
        this.mentorService = mentorService;
        this.imageService = imageService;
    }

    @PostMapping("/offer")
    public OfferDto addOffer(@RequestBody NewOfferDto offerDto, Principal principal) {
        String name = principal.getName();
        Image imageData = imageService.getImageFromDb(offerDto.getImageName());
        offerDto.setImage(imageData);
        return mentorService.addOffer(name, offerDto);
    }

}
