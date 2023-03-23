package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.NewLetterDto;
import com.codecool.elproyectegrande1.entity.Inbox;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.mapper.InboxMapper;
import com.codecool.elproyectegrande1.repository.InboxRepository;
import com.codecool.elproyectegrande1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InboxService {

    private final InboxRepository inboxRepository;
    private final InboxMapper inboxMapper;
    private final UserRepository userRepository;

    @Autowired
    public InboxService(InboxRepository inboxRepository, InboxMapper inboxMapper,
                        UserRepository userRepository) {
        this.inboxRepository = inboxRepository;
        this.inboxMapper = inboxMapper;
        this.userRepository = userRepository;
    }

    public List<Inbox> getAllLetters() {
        return inboxRepository.findAll();
    }

    public Inbox getLetterById(Long id) {
        return inboxRepository.findById(id).orElse(null);
    }

    public Inbox addLetter(String user_name, NewLetterDto newLetterDto) {
        Optional<User> user = userRepository.findByUsername(user_name);
        return inboxRepository.save(user.get().getInbox());
    }

    public void deleteLetterById(Long id) {
        inboxRepository.deleteById(id);
    }
}
