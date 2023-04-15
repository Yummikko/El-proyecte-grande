package com.codecool.elproyectegrande1.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.security.AuthProvider;

public class AppUser {

    // TODO this class should be entity with fields
    //  id; (as String with uuid2 strategy)
    //  name;
    //  email;
    //  imageUrl;
    //  emailVerified default false;
    //  password default null;
    //  AuthProvider provider;
    //  String providerId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Size(max = 120)
    private String imageUrl;

    private AuthProvider provider;

    private String providerId;
}
