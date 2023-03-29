package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByName(String fileName);

    @Query("SELECT i FROM Image i WHERE i.name = :fileName AND i.id = max(i.id)")
    Image findImageByName(String fileName);
}
