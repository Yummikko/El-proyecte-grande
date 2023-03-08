package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.User;

import java.math.BigDecimal;

public class DreamerDto {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private int followers = 0;

    private BigDecimal funds;

    private User user;

    public DreamerDto() {
    }

    public DreamerDto(Long id, String nickname, String email, String password, int followers, User user) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.followers = followers;
        this.funds = new BigDecimal(0);
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

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
