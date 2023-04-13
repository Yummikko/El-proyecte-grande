package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.entity.Image;
import com.codecool.elproyectegrande1.entity.Offer;
import com.codecool.elproyectegrande1.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NewDreamerDto {
    private String nickname;
    private String email;
    private BigDecimal funds = new BigDecimal(0);
    private User user;
    private Set<String> letters;
    private String imageName;
    private Image image;
    private List<Dream> dreams = new ArrayList<>();


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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Dream> getDreams() {
        return dreams;
    }

    public void setDreams(List<Dream> dreams) {
        this.dreams = dreams;
    }
}
