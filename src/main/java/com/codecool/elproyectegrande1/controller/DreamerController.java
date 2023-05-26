package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.dream.DreamDto;
import com.codecool.elproyectegrande1.dto.dreamer.DreamerDto;
import com.codecool.elproyectegrande1.dto.dreamer.NewDreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.entity.Image;
import com.codecool.elproyectegrande1.service.DreamerService;
import com.codecool.elproyectegrande1.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/dreamers")
public class DreamerController {

    private final DreamerService dreamerService;

    @Autowired
    public DreamerController(DreamerService dreamerService) {
        this.dreamerService = dreamerService;
    }

    @PostMapping ("/create")
    public DreamerDto createDreamer(@RequestBody NewDreamerDto newDreamerDto) {
        return dreamerService.createDreamer(newDreamerDto);
    }

    @GetMapping("/{nickname}")
    public DreamerDto getDreamerByNickname(@PathVariable("nickname") String nickname) {
        return dreamerService.getDreamerByNickname(nickname);
    }


    @PutMapping("/{nickname}/follow")
    public ResponseEntity<String> followDreamer(@PathVariable("nickname") String nickname, Principal principal) {
        String name = principal.getName();
        dreamerService.followDreamer(nickname, name);
            return new ResponseEntity<>("Followed successfully!", HttpStatus.OK);
    }

    @PutMapping("/{nickname}/unfollow")
    public ResponseEntity<String> unfollowDreamer(@PathVariable String nickname) {
        dreamerService.unfollowDreamer(nickname);
        return new ResponseEntity<>("You have unfollowed this dreamer", HttpStatus.OK);
    }

    @GetMapping("/most-followed")
    public Dreamer getMostPopularDreamer() {
        return dreamerService.getDreamerWithMostFollowers();
    }

    @PutMapping("/donate/{id}/{amount}")
    public ResponseEntity<String> donateDreamer(@PathVariable Long id, @PathVariable BigDecimal amount) {
        dreamerService.donateDreamer(id, amount);
        return new ResponseEntity<>("You have donated to this dreamer", HttpStatus.OK);
    }

    @GetMapping("/{nickname}/dreams")
    public List<DreamDto> getAllDreamsByDreamerId(@PathVariable("nickname") String nickname) {
        return dreamerService.getAllDreamsByDreamerNickname(nickname);
    }
}
