package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.Offer;
import com.codecool.elproyectegrande1.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MentorDto {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private int followers = 0;
    private List<Offer> offers = new ArrayList<>();
    private User user;

    public MentorDto() {
    }

    public MentorDto(Long id, String nickname, String email, int followers, List<Offer> offers, User user) {
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

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getFollowers() {
        return followers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
