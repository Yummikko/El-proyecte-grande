package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public OfferDto getDreamById(@PathVariable("id") Long id) {
        return offerService.getOfferById(id);
    }
}

