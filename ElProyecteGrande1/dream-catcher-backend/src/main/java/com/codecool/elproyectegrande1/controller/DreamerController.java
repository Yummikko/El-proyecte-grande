package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.DreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.service.DreamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dreamers")
public class DreamerController {

    private final DreamerService dreamerService;

    @Autowired
    public DreamerController(DreamerService dreamerService) {
        this.dreamerService = dreamerService;
    }


    @GetMapping("/{id}")
    public DreamerDto getDreamerById(@PathVariable("id") Long id) {
        return dreamerService.getDreamerById(id);
    }


    @PutMapping("/{id}/follow")
    public void followDreamer(@PathVariable Long id) {
        dreamerService.followDreamer(id);
    }


    @GetMapping("/most-followed")
    public Dreamer getMostPopularDreamer() {
        return dreamerService.getDreamerWithMostFollowers();
    }
}
