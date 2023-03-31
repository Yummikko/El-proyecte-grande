package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.DreamStatus;
import com.codecool.elproyectegrande1.entity.Image;

import java.util.List;

public class DreamDto {

    private Long id;
    private String dreamTitle;
    private String dreamDescription;
    private int likes = 0;
    private int views = 0;
    private DreamStatus dreamStatus;
    private List<String> hashtags;
    private List<String> comments;
    private Image image;

    public DreamDto() {
    }

    public DreamDto(Long id, String dreamTitle, String dreamDescription, List<String> hashtags, Image image) {
        this.id = id;
        this.dreamTitle = dreamTitle;
        this.dreamDescription = dreamDescription;
        this.hashtags = hashtags;
        this.image = image;
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

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
