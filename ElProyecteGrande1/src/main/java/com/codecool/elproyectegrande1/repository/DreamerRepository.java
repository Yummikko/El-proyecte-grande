package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DreamerRepository extends JpaRepository<Dream, Long> {
}
