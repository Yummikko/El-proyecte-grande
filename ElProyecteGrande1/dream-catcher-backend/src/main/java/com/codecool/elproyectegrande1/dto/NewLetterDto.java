package com.codecool.elproyectegrande1.dto;

public class NewLetterDto {

    private String content;

    NewLetterDto() {

    }

    public NewLetterDto(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
