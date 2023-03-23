package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.NewCommentDto;
import com.codecool.elproyectegrande1.dto.NewLetterDto;
import com.codecool.elproyectegrande1.entity.Inbox;
import com.codecool.elproyectegrande1.service.InboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inbox")
public class InboxController {

    @Autowired
    private InboxService inboxService;

    @GetMapping("")
    public List<Inbox> getAllLetters() {
        return inboxService.getAllLetters();
    }

    @GetMapping("/{id}")
    public Inbox getLetterById(@PathVariable Long id) {
        return inboxService.getLetterById(id);
    }

    @PostMapping("/{user_name}/new_letter")
    public Inbox sendLetter(@PathVariable String user_name, @RequestBody NewLetterDto newLetterDto) {
        return inboxService.addLetter(user_name, newLetterDto);
    }

    @DeleteMapping("/{id}")
    public void deleteLetterById(@PathVariable Long id) {
        inboxService.deleteLetterById(id);
    }
}
