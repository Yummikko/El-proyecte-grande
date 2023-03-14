package com.codecool.elproyectegrande1.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First Name cannot be empty")
    @Column(name = "nickname")
    private String nickname;

    @NotNull(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email address")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "followers", columnDefinition = "INT DEFAULT 0")
    private int followers;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    private List<Offer> offers = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Mentor() {
    }

    public Mentor(Long id, String nickname, String email, int followers, List<Offer> offers, User user) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.followers = followers;
        this.offers = offers;
        this.user = user;
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

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
