package com.codecool.elproyectegrande1.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Dream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String dreamTitle;

    @NotBlank
    private String dreamDescription;

    @Column(name = "likes", columnDefinition = "INT DEFAULT 0")
    private int likes;

    @Enumerated(EnumType.STRING)
    @Column(name = "dream_status")
    private DreamStatus dreamStatus;

    public Dream() {
    }

    public Dream(String dreamTitle, String dreamDescription, int likes) {
        this.dreamTitle = dreamTitle;
        this.dreamDescription = dreamDescription;
        this.likes = 0;
        this.dreamStatus = DreamStatus.PRESENTING;
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

    public DreamStatus getDreamStatus() {
        return dreamStatus;
    }

    public void setDreamStatus(DreamStatus dreamStatus) {
        this.dreamStatus = dreamStatus;
    }
}
