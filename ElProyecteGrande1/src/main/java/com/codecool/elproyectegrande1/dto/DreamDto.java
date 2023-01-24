package com.codecool.elproyectegrande1.dto;

public class DreamDto {

    private Long id;
    private String dreamTitle;
    private String dreamDescription;

    public DreamDto() {
    }

    public DreamDto(Long id, String dreamTitle, String dreamDescription) {
        this.id = id;
        this.dreamTitle = dreamTitle;
        this.dreamDescription = dreamDescription;
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
}
