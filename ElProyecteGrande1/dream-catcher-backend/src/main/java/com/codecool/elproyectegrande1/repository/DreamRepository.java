package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Dream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DreamRepository extends JpaRepository<Dream, Long> {
    Dream findTopByOrderByLikesDesc();
    Dream findTopByOrderByViewsDesc();

   @Query("SELECT d FROM Dream d JOIN d.hashtags h WHERE h = :hashtag")
   List<Dream> findByHashtagsContaining(String hashtag);
}

