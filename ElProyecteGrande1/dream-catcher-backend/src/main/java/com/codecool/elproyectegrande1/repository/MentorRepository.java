package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
