package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.comment.CommentDto;
import com.codecool.elproyectegrande1.dto.comment.NewCommentDto;
import com.codecool.elproyectegrande1.entity.Comment;
import com.codecool.elproyectegrande1.mapper.CommentMapper;
import com.codecool.elproyectegrande1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;


    @Autowired
    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public CommentDto addComment(NewCommentDto newCommentDto, String username) {
        Comment toBeSaved = commentMapper.mapNewCommentDtoToEntity(newCommentDto, username);
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

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.delete(comment);
    }

    public Set<CommentDto> getAllCommentsByDreamId(Long dreamId) {
        List<Comment> comments = commentRepository.findAllById(Collections.singleton(dreamId));
        return comments.stream()
                .map(commentMapper::mapEntityToCommentDto)
                .collect(Collectors.toSet());
    }
}
