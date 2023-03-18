package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.Inbox;

import java.time.LocalDateTime;

public class NewLetterDto {

    private Long id;
    private String content;
    private LocalDateTime dateTime;
    private Inbox inbox;

    public NewLetterDto(Long id, String content, LocalDateTime dateTime, Inbox inbox) {
        this.id = id;
        this.content = content;
        this.dateTime = dateTime;
        this.inbox = inbox;
    }

    public NewLetterDto() {
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inbox getInbox() {
        return inbox;
    }

    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
    }
}
