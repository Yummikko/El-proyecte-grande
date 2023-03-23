package com.codecool.elproyectegrande1.dto;

public class NewLetterDto {

    private String content;

    NewLetterDto() {

    }

    NewLetterDto(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
