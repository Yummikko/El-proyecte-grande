package com.codecool.elproyectegrande1.dto;

import javax.persistence.criteria.CriteriaBuilder;

public class DreamDto {

    private Long id;
    private String dreamTitle;
    private String dreamDescription;
    private int likes = 0;

    public DreamDto() {
    }

    public DreamDto(Long id, String dreamTitle, String dreamDescription, int likes) {
        this.id = id;
        this.dreamTitle = dreamTitle;
        this.dreamDescription = dreamDescription;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDreamTitle() {
        return dreamTitle;
    }

    public void setDreamTitle(String dreamTitle) {
        this.dreamTitle = dreamTitle;
    }

    public String getDreamDescription() {
        return dreamDescription;
    }

    public void setDreamDescription(String dreamDescription) {
        this.dreamDescription = dreamDescription;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
