package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.EOffer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OfferDto {
    private EOffer type;
    private String title;
    private String description;
    private BigDecimal price;
    private LocalDate date;

    public OfferDto() {
    }

    public OfferDto(EOffer type, String title, String description, BigDecimal price, LocalDate date) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
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

}
