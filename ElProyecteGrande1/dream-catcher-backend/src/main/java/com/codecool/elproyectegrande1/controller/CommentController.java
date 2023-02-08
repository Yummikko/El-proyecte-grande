package com.codecool.elproyectegrande1.controller;


import com.codecool.elproyectegrande1.dto.CommentDto;
import com.codecool.elproyectegrande1.dto.NewCommentDto;
import com.codecool.elproyectegrande1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public CommentDto addComment(@RequestBody NewCommentDto NewCommentDto) {
        return commentService.addComment(NewCommentDto);
    }

    @PutMapping("/{id}/like")
    public void likeComment(@PathVariable Long id) {
        commentService.likeComment(id);
    }

    @PutMapping("{id}/update-comment/{comment}/{updatedDate}")
    public void updateComment(@PathVariable Long id, @PathVariable String comment, @PathVariable Date updatedDate) {
        commentService.updateComment(id, comment, updatedDate);
    }
}
