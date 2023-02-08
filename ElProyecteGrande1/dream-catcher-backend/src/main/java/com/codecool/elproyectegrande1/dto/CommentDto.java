package com.codecool.elproyectegrande1.dto;

import java.util.Date;


public class CommentDto {

    private Long id;
    private String comment;

    private Date createdDate;

    private Date updatedDate;

    private int likes = 0;

    public CommentDto(Long id, String comment, Date createdDate, Date updatedDate, int likes) {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
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

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
