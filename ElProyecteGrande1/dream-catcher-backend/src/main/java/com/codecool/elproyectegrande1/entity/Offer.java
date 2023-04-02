package com.codecool.elproyectegrande1.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mentor mentor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EOffer type;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Image image;

    public Offer() {
    }

    public Offer(EOffer type, String title, String description, BigDecimal price, LocalDate date, Image image) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
        this.image = image;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
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
}
