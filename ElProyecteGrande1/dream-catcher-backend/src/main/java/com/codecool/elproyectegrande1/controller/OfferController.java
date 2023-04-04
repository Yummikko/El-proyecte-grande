package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.CommentDto;
import com.codecool.elproyectegrande1.dto.NewCommentDto;
import com.codecool.elproyectegrande1.dto.OfferDto;
import com.codecool.elproyectegrande1.service.OfferService;
import com.codecool.elproyectegrande1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;
    private final CommentService commentService;
    private boolean isLoggedIn = false;

    @Autowired
    public OfferController(OfferService offerService, CommentService commentService) {
        this.offerService = offerService;
        this.commentService = commentService;
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

    @PostMapping("/{id}/comment")
    public CommentDto addComment(@RequestBody NewCommentDto newCommentDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return commentService.addComment(newCommentDto, username);
    }
}

