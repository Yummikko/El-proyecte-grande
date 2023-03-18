package com.codecool.elproyectegrande1.controller;

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

    @PostMapping("")
    public Inbox addLetter(@RequestBody Inbox inbox) {
        return inboxService.addLetter(inbox);
    }

    @DeleteMapping("/{id}")
    public void deleteLetterById(@PathVariable Long id) {
        inboxService.deleteLetterById(id);
    }
}
