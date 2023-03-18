package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.Letter;
import com.codecool.elproyectegrande1.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InboxDto {

    private Long id;

    private List<Letter> letters = new ArrayList<>();

    private User user;

    public InboxDto(Long id, List<Letter> letters, User user) {
        this.id = id;
        this.letters = letters;
        this.user = user;
    }

    public InboxDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
