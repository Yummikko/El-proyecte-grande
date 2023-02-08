package com.codecool.elproyectegrande1.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @CreatedDate
    private Date createdDate;

    private Date updatedDate;

//    @ManyToOne
//    private Dreamer dreamer;

    public Comment(String commentText, int likes) {
        this.commentText = commentText;
        this.likes = likes;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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

//    public void setDreamer(Dreamer dreamer) {
//        this.dreamer = dreamer;
//    }
}
