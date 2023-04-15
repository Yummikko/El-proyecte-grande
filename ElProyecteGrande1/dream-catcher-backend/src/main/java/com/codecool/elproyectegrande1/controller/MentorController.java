package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.NewOfferDto;
import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.entity.Image;
import com.codecool.elproyectegrande1.service.ImageService;
import com.codecool.elproyectegrande1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public OfferDto addOffer(@RequestBody NewOfferDto offerDto, HttpSession session) {
        Long id = (Long) session.getAttribute("id");
        Image imageData = imageService.getImageFromDb(offerDto.getImageName());
        offerDto.setImage(imageData);
        return mentorService.addOffer(id, offerDto);
    }

}
