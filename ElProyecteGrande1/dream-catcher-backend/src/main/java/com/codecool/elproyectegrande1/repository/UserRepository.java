package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User findByEmail(String email);
}
