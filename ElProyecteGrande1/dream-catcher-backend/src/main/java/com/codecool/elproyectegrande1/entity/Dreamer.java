package com.codecool.elproyectegrande1.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dreamers")
public class Dreamer {

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

    @Column(name = "funds", columnDefinition = "INT DEFAULT 0")
    private BigDecimal funds;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ElementCollection
    private Set<String> letters;

    @ManyToOne(fetch = FetchType.LAZY)
    private Image profilePicture;

    @OneToMany(mappedBy = "dreamer", cascade = CascadeType.ALL)
    private List<Dream> dreams = new ArrayList<>();

    public Dreamer() {
    }

    public Dreamer(String nickname, String email, User user, Set<String> letters) {
        this.nickname = nickname;
        this.email = email;
        this.user = user;
        this.letters = letters;
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

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Dream> getDreams() {
        return dreams;
    }

    public void setDreams(List<Dream> dreams) {
        this.dreams = dreams;
    }
}