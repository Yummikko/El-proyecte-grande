package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Mentor;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository {
    Mentor findByEmail(String email);
}
