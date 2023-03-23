package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.NewLetterDto;
import com.codecool.elproyectegrande1.entity.Letter;
import com.codecool.elproyectegrande1.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inbox")
public class LetterController {

    @Autowired
    private LetterService letterService;

    @GetMapping("")
    public List<Letter> getAllLetters() {
        return letterService.getAllLetters();
    }

    @GetMapping("/{id}")
    public Letter getLetterById(@PathVariable Long id) {
        return letterService.getLetterById(id);
    }

    @PostMapping("/{recipient_name}/new_letter")
    public NewLetterDto sendLetter(@PathVariable String recipient_name, @RequestBody NewLetterDto newLetterDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String sender = authentication.getName();
        return letterService.addLetter(sender, newLetterDto);
    }

    @DeleteMapping("/{id}")
    public void deleteLetterById(@PathVariable Long id) {
        letterService.deleteLetterById(id);
    }
}
