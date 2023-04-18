package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Optional<Mentor> findByUserId(Long user_id);
    Optional<Mentor> findByNickname(String name);
}
