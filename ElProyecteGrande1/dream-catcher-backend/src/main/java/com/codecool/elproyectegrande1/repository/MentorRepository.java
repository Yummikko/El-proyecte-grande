package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Mentor;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository {
    public Mentor findByEmail(String email);
}
