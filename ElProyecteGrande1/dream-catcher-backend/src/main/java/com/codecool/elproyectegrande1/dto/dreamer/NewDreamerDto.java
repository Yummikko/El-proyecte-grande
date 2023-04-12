package com.codecool.elproyectegrande1.dto.dreamer;

import com.codecool.elproyectegrande1.entity.User;

import java.math.BigDecimal;
import java.util.Set;

public class NewDreamerDto {
    private String nickname;
    private String email;

    private BigDecimal funds = new BigDecimal(0);

    private User user;

    private Set<String> letters;


    public NewDreamerDto(String nickname, String email, User user, Set<String> letters) {
        this.nickname = nickname;
        this.email = email;
        this.user = user;
        this.letters = letters;
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
