package com.codecool.elproyectegrande1.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Dream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String dreamTitle;

    @NotBlank
    private String dreamDescription;

    @Column(name = "likes", columnDefinition = "INT DEFAULT 0")
    private int likes;

    @Column(name = "views", columnDefinition = "INT DEFAULT 0")
    private int views;

    @Enumerated(EnumType.STRING)
    @Column(name = "dream_status")
    private DreamStatus dreamStatus;

    @ElementCollection
    private List<String> hashtags;

    @ElementCollection
    private List<String> comments;

    @Column(nullable = true, length = 64)
    private String photo;

    public Dream() {
    }

    public Dream(String dreamTitle, String dreamDescription, int likes, int views, List<String> hashtags, List<String> comments, String photo) {
        this.dreamTitle = dreamTitle;
        this.dreamDescription = dreamDescription;
        this.likes = 0;
        this.views = 0;
        this.dreamStatus = DreamStatus.PRESENTING;
        this.hashtags = hashtags;
        this.comments = comments;
        this.photo = photo;
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}