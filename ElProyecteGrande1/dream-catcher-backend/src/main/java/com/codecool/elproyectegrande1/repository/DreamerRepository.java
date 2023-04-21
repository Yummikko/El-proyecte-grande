package com.codecool.elproyectegrande1.repository;


import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.entity.Dreamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DreamerRepository extends JpaRepository<Dreamer, Long> {
    Dreamer findByEmail(String email);

    Optional<Dreamer> findByUserId(Long user_id);

    Optional<Dreamer> findByNickname(String name);

    Dreamer findTopByOrderByFollowersDesc();
}
