package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.DreamStatus;

import javax.persistence.criteria.CriteriaBuilder;

public class DreamDto {

    private Long id;
    private String dreamTitle;
    private String dreamDescription;
    private int likes = 0;

    private int views = 0;

    private DreamStatus dreamStatus;

    public DreamDto() {
    }

    public DreamDto(Long id, String dreamTitle, String dreamDescription, int likes, int views, DreamStatus dreamStatus) {
        this.id = id;
        this.dreamTitle = dreamTitle;
        this.dreamDescription = dreamDescription;
        this.likes = likes;
        this.views = views;
        this.dreamStatus = dreamStatus;
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

    public int getViews() { return views; }

    public void setViews(int views) { this.views = views; }

    public DreamStatus getDreamStatus() {
        return dreamStatus;
    }

    public void setDreamStatus(DreamStatus dreamStatus) {
        this.dreamStatus = dreamStatus;
    }
}
