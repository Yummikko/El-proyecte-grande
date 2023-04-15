package com.codecool.elproyectegrande1.security;

import com.codecool.elproyectegrande1.config.AppConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenProvider {

    private final AppConfig appConfig;

    public String createToken(Authentication authentication) {
        throw new RuntimeException("not implemented");
    }

    public String getUserIdFromToken(String token) {
        throw new RuntimeException("not implemented");
    }

    public boolean validateToken(String token) {
        throw new RuntimeException("not implemented");
    }
}
