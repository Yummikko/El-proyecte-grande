package com.codecool.elproyectegrande1.repository;


import com.codecool.elproyectegrande1.entity.Dreamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DreamerRepository extends JpaRepository<Dreamer, Long> {
    Dreamer findByEmail(String email);

    Dreamer findByNickname(String nickname);
}
