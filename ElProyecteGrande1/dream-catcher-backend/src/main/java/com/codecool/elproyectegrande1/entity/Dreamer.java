package com.codecool.elproyectegrande1.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dreamers")
public class Dreamer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First Name cannot be empty")
    @Column(name = "nickname")
    private String nickname;

    @NotNull(message = "Password cannot be empty")
    @Length(min = 7, message = "Password should be at least 7 characters long")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email address")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "followers", columnDefinition = "INT DEFAULT 0")
    private int followers;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    public Dreamer() {
    }

    public Dreamer(Long id, String nickname, String email, String password, int followers) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.followers = followers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}