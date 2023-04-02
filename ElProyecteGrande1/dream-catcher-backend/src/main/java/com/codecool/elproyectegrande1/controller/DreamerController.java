package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.DreamerDto;
import com.codecool.elproyectegrande1.dto.NewDreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.service.DreamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/dreamers")
public class DreamerController {

    private final DreamerService dreamerService;
    private boolean isLoggedIn = false;

    @Autowired
    public DreamerController(DreamerService dreamerService) {
        this.dreamerService = dreamerService;
    }

    @PostMapping ("/create")
    public DreamerDto createDreamer(@RequestBody NewDreamerDto newDreamerDto) {
        return dreamerService.createDreamer(newDreamerDto);
    }

    @GetMapping("/{id}")
    public DreamerDto getDreamerById(@PathVariable("id") Long id) {
        return dreamerService.getDreamerById(id);
    }


    @PutMapping("/{id}/follow")
    public ResponseEntity<String> followDreamer(@PathVariable("id") Long id) {
        if (isLoggedIn) {
            dreamerService.followDreamer(id);
            return new ResponseEntity<>("Followed successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Please log in to follow the dreamer.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}/unfollow")
    public ResponseEntity<String> unfollowDreamer(@PathVariable Long id) {
        dreamerService.unfollowDreamer(id);
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
}
