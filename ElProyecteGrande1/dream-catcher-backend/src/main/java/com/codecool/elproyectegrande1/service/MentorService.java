package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.mapper.MentorMapper;
import com.codecool.elproyectegrande1.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;

    @Autowired
    public MentorService(MentorRepository mentorRepository, MentorMapper mentorMapper) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
    }
}
