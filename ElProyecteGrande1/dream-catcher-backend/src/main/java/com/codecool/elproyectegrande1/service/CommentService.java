package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.CommentDto;
import com.codecool.elproyectegrande1.dto.NewCommentDto;
import com.codecool.elproyectegrande1.entity.Comment;
import com.codecool.elproyectegrande1.mapper.CommentMapper;
import com.codecool.elproyectegrande1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;


    @Autowired
    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public CommentDto addComment(NewCommentDto newCommentDto) {
        Comment toBeSaved = commentMapper.mapNewCommentDtoToEntity(newCommentDto);
        Comment savedComment = commentRepository.save(toBeSaved);
        return commentMapper.mapEntityToCommentDto(savedComment);
    }

    public void likeComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setLikes(comment.getLikes() + 1);
        commentRepository.save(comment);
    }

    public void updateComment(Long id, String description, LocalDateTime updatedDate) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        comment.setComment(description);
        comment.setTimeUpdated(updatedDate);
        commentRepository.save(comment);
    }
}
