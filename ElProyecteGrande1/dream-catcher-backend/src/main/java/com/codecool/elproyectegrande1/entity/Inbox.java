package com.codecool.elproyectegrande1.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "inbox", cascade = CascadeType.ALL)
    private List<Letter> letters = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Inbox(Long id) {
        this.id = id;
    }

    public Inbox() {
    }

    public Long getId() {
        return id;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public void setId(Long id) {
        this.id = id;
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

