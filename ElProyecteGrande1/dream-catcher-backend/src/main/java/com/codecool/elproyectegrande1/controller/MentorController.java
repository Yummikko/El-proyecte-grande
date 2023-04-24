package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.dream.DreamDto;
import com.codecool.elproyectegrande1.dto.dreamer.DreamerDto;
import com.codecool.elproyectegrande1.dto.mentor.MentorDto;
import com.codecool.elproyectegrande1.dto.offer.NewOfferDto;
import com.codecool.elproyectegrande1.dto.offer.OfferDto;
import com.codecool.elproyectegrande1.service.ImageService;
import com.codecool.elproyectegrande1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.security.Principal;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:8081")
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
        return mentorService.addOffer(name, offerDto);
    }

    @GetMapping("/all")
    public List<MentorDto> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @GetMapping("/{nickname}")
    public MentorDto getMentorByNickname(@PathVariable("nickname") String nickname) {
        return mentorService.getMentorByNickname(nickname);
    }

//    @GetMapping("/{id}")
//    public MentorDto getMentor(@PathVariable("id") String id) {
//        return mentorService.getMentor(id);
//    }

    @GetMapping("/{nickname}/offers")
    public List<OfferDto> getAllOffersByMentorNickname(@PathVariable("nickname") String nickname) {
        return mentorService.getAllOffersByMentorNickname(nickname);
    }

    @PutMapping("/{id}/follow")
    public ResponseEntity<String> followMentor(@PathVariable("id") Long id, Principal principal) {
//        if (!Objects.equals(principal.getName(), "")) {
            mentorService.followMentor(id);
            return new ResponseEntity<>("Followed successfully!", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Please log in to follow the dreamer.", HttpStatus.BAD_REQUEST);
//        }
    }

    @PutMapping("/{id}/unfollow")
    public ResponseEntity<String> unfollowMentor(@PathVariable Long id) {
        mentorService.unfollowMentor(id);
        return new ResponseEntity<>("You have unfollowed this dreamer", HttpStatus.OK);
    }

}
