package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.entity.Mentor;
import com.codecool.elproyectegrande1.exceptions.MentorNotFoundException;
import com.codecool.elproyectegrande1.mapper.MentorMapper;
import com.codecool.elproyectegrande1.repository.MentorRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class AdminService {

    private final MentorMapper mentorMapper;
    private final MentorRepository mentorRepository;

    public AdminService(MentorMapper mentorMapper, MentorRepository mentorRepository) {
        this.mentorMapper = mentorMapper;
        this.mentorRepository = mentorRepository;
    }

    public void approveMentor(String mentorName){
            Mentor mentor = mentorRepository.findByNickname(mentorName).orElseThrow(()-> new MentorNotFoundException("Mentor not found"));
            mentor.setVerified(true);
            mentorRepository.save(mentor);
        }
}