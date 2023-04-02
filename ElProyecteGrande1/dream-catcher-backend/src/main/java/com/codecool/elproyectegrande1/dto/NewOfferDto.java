package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.EOffer;
import com.codecool.elproyectegrande1.entity.Image;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewOfferDto {
    private EOffer type;
    private String title;
    private String description;
    private BigDecimal price;
    private LocalDate date;
    private Image image;
    private String imageName;

    public NewOfferDto() {
    }

    public NewOfferDto(EOffer type, String title, String description, BigDecimal price, LocalDate date, String imageName) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
        this.imageName = imageName;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
