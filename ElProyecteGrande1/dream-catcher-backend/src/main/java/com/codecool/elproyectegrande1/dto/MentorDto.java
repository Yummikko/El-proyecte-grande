package com.codecool.elproyectegrande1.dto;

public class MentorDto {
    private Long id;
    private String nickname;
    private String email;
    private int followers = 0;

    public MentorDto() {
    }

    public MentorDto(Long id, String nickname, String email, int followers) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
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

}
