package com.codecool.elproyectegrande1.dto;

import java.time.LocalDateTime;


public class CommentDto {

    private Long id;
    private String comment;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private int likes = 0;

    public CommentDto(Long id, String comment, LocalDateTime createdDate, LocalDateTime updatedDate, int likes) {
        this.id = id;
        this.comment = comment;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public int getLikes() {
        return likes;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
