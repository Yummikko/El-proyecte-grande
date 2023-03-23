package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByName(String fileName);
}
