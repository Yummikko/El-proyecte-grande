package com.codecool.elproyectegrande1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity(
        jsr250Enabled = true    // Enables @RolesAllowed (Ensures JSR-250 annotations are enabled)
)
@SpringBootApplication
public class ElProyecteGrande1 {

    public static void main(String[] args) {
        SpringApplication.run(ElProyecteGrande1.class, args);
    }

}