package com.codecool.elproyectegrande1.dto.letter;

public class NewLetterDto {

    private String content;
    private String sender;

    public NewLetterDto(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
