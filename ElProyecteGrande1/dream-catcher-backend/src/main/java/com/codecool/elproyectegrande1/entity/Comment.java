package com.codecool.elproyectegrande1.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 10, max = 350)
    private String commentText;

    @Column(name = "likes", columnDefinition = "INT DEFAULT 0")
    private int likes;

    private LocalDateTime timeCreated;

    private LocalDateTime timeUpdated = null;

    private String username;

//    @ManyToOne
//    private Dreamer dreamer;


    public Comment(String commentText, int likes, String username) {
        this.commentText = commentText;
        this.likes = likes;
        this.timeCreated =  LocalDateTime.now();
        this.username = username;
    }


    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return commentText;
    }

    public String getCommentText() {
        return commentText;
    }

//    public Dreamer getDreamer() {
//        return dreamer;
//    }


    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeUpdated() {
        return timeUpdated;
    }

    public int getLikes() {
        return likes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public void setTimeUpdated(LocalDateTime timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public void setComment(String comment) {
        this.commentText = comment;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //    public void setDreamer(Dreamer dreamer) {
//        this.dreamer = dreamer;
//    }
}
