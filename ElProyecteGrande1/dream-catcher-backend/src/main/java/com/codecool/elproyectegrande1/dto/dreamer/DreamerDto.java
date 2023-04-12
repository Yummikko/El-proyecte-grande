package com.codecool.elproyectegrande1.dto.dreamer;

import com.codecool.elproyectegrande1.entity.User;

import java.math.BigDecimal;
import java.util.Set;

public class DreamerDto {
    private Long id;
    private String nickname;
    private String email;
    private int followers = 0;

    private BigDecimal funds;

    private User user;

    private Set<String> letters;

    public DreamerDto() {
    }

    public DreamerDto(Long id, String nickname, String email, int followers, User user, Set<String> letters) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.followers = followers;
        this.funds = new BigDecimal(0);
        this.user = user;
        this.letters = letters;
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

    public Set<String> getLetters() {
        return letters;
    }

    public void setLetters(Set<String> letters) {
        this.letters = letters;
    }
}
