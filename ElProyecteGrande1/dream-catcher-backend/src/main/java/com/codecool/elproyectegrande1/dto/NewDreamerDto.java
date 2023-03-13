package com.codecool.elproyectegrande1.dto;

import java.math.BigDecimal;

public class NewDreamerDto {
    private String nickname;
    private String email;

    private BigDecimal funds = new BigDecimal(0);


    public NewDreamerDto(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
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
}
