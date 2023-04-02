package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.ERole;
import com.codecool.elproyectegrande1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
