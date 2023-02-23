package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DreamRepository extends JpaRepository<Dream, Long> {
    Dream findTopByOrderByLikesDesc();
    Dream findTopByOrderByViewsDesc();
    List<Dream> findByHashtagsContaining(String hashtag);
}

