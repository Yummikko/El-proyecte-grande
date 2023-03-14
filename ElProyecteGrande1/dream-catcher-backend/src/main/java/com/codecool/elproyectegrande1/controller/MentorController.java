package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mentors")
public class MentorController {

    private final MentorService mentorService;
    private boolean isLoggedIn = false;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/{id}/offer")
    public OfferDto addOffer(@PathVariable Long id, @RequestBody OfferDto offerDto) {
        return mentorService.addOffer(id, offerDto);
    }

}
