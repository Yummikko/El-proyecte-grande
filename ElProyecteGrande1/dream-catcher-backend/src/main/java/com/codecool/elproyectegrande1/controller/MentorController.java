package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.MentorDto;
import com.codecool.elproyectegrande1.dto.NewOfferDto;
import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.dto.offer.NewOfferDto;
import com.codecool.elproyectegrande1.dto.offer.OfferDto;
import com.codecool.elproyectegrande1.entity.Image;
import com.codecool.elproyectegrande1.service.ImageService;
import com.codecool.elproyectegrande1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Image imageData = imageService.getImageFromDb(offerDto.getImageName());
        System.out.println(imageData);
        offerDto.setImage(imageData);
        return mentorService.addOffer(name, offerDto);
    }

    @GetMapping("/all")
    public List<MentorDto> getAllMentors() {
        return mentorService.getAllMentors();
    }

}
