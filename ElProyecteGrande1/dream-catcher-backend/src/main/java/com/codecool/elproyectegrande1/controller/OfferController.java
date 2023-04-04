package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;
    private boolean isLoggedIn = false;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{id}")
    public OfferDto getOfferById(@PathVariable("id") Long id) {
        offerService.viewsOffer(id);
        return offerService.getOfferById(id);
    }

    @GetMapping("/all")
    public List<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }

    @PutMapping("/{id}/like")
    public void likeOffer(@PathVariable Long id) {
        offerService.likeOffer(id);
    }

    @GetMapping("/{id}/offer")
    public void viewOffer(@PathVariable Long id) {
        offerService.viewsOffer(id);
    }
}

