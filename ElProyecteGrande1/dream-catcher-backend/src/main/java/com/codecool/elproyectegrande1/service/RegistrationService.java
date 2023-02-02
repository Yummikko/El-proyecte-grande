package com.codecool.elproyectegrande1.service;


import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.repository.DreamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private DreamerRepository dreamerRepository;

    public void register(Dreamer dreamer) {
        // walidacja danych użytkownika
        if (dreamerRepository.findByNickname(dreamer.getNickname())!=null) {
            throw new RuntimeException("Username already exists");
        }
        if (dreamerRepository.findByEmail(dreamer.getEmail())!=null) {
            throw new RuntimeException("Email already exists");
        }
        // zapis danych użytkownika do bazy danych
        dreamerRepository.save(dreamer);
    }
}