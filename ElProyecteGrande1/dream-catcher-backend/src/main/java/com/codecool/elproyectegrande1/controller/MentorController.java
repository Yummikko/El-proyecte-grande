package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.offer.NewOfferDto;
import com.codecool.elproyectegrande1.dto.offer.OfferDto;
import com.codecool.elproyectegrande1.service.ImageService;
import com.codecool.elproyectegrande1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/mentors")
public class MentorController {

    private final MentorService mentorService;
    private final ImageService imageService;

    @Autowired
    public MentorController(MentorService mentorService, ImageService imageService) {
        this.mentorService = mentorService;
        this.imageService = imageService;
    }

    @PostMapping("/offer")
    public OfferDto addOffer(@RequestBody NewOfferDto offerDto, Principal principal) {
        String name = principal.getName();
        return mentorService.addOffer(name, offerDto);
    }

}
