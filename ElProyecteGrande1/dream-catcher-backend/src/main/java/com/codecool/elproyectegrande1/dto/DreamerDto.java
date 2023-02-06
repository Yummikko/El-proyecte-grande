package com.codecool.elproyectegrande1.dto;

public class DreamerDto {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private int followers = 0;

    public DreamerDto() {
    }

    public DreamerDto(Long id, String nickname, String email, String password, int followers) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.followers = followers;
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
}
