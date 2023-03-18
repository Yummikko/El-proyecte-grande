package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.entity.Inbox;
import com.codecool.elproyectegrande1.mapper.InboxMapper;
import com.codecool.elproyectegrande1.repository.InboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboxService {

    private final InboxRepository inboxRepository;
    private final InboxMapper inboxMapper;

    @Autowired
    public InboxService(InboxRepository inboxRepository, InboxMapper inboxMapper) {
        this.inboxRepository = inboxRepository;
        this.inboxMapper = inboxMapper;
    }

    public List<Inbox> getAllLetters() {
        return inboxRepository.findAll();
    }

    public Inbox getLetterById(Long id) {
        return inboxRepository.findById(id).orElse(null);
    }

    public Inbox addLetter(Letter letter) {
        return inboxRepository.save(inbox);
    }

    public void deleteLetterById(Long id) {
        inboxRepository.deleteById(id);
    }
}
