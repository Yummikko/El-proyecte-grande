package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.mapper.MentorMapper;
import com.codecool.elproyectegrande1.repository.MentorRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final MentorMapper mentorMapper;
    private final MentorRepository mentorRepository;

    public AdminService(MentorMapper mentorMapper, MentorRepository mentorRepository) {
        this.mentorMapper = mentorMapper;
        this.mentorRepository = mentorRepository;
    }

//    public void approveMentor(Mentor mentor, User admin) {
//        if (admin != null && admin.isAdmin()) {
//            mentor.setVerified(true);
//            System.out.println("Mentor " + mentor.getNickname() + " został zatwierdzony przez administratora.");
//        } else {
//            System.out.println("Brak uprawnień administratora do zatwierdzenia mentora.");
//        }
//    }
}
