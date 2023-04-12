package com.codecool.elproyectegrande1.dto.comment;


public class NewCommentDto {

    private String comment;

//    private Dreamer dreamer;


    public NewCommentDto(String comment) {
        this.comment = comment;
    }

    public NewCommentDto() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}

