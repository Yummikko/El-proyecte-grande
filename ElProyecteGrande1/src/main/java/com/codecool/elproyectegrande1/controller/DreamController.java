package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.DreamDto;
import com.codecool.elproyectegrande1.dto.NewDreamDto;
import com.codecool.elproyectegrande1.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dreams")
public class DreamController {

    private final DreamService dreamService;

    @Autowired
    public DreamController(DreamService dreamService) {
        this.dreamService = dreamService;
    }

    @PostMapping
    public DreamDto createNewUserStory(@RequestBody NewDreamDto newDreamDto) {
        return dreamService.addDream(newDreamDto);
    }
}
