package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.EOffer;
import com.codecool.elproyectegrande1.entity.Image;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OfferDto {
    private EOffer type;
    private String title;
    private String description;
    private BigDecimal price;
    private LocalDate date;
    private Image image;
    private int likes = 0;
    private int views = 0;
    private List<String> comments;

    public OfferDto() {
    }

    public OfferDto(EOffer type, String title, String description, BigDecimal price, LocalDate date, Image image, int likes, int views, List<String> comments) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
        this.image = image;
        this.likes = likes;
        this.views = views;
        this.comments = comments;
    }

    public EOffer getType() {
        return type;
    }

    public void setType(EOffer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
