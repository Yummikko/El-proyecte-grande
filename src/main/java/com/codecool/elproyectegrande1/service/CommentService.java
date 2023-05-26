package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.comment.CommentDto;
import com.codecool.elproyectegrande1.dto.comment.NewCommentDto;
import com.codecool.elproyectegrande1.dto.dream.DreamDto;
import com.codecool.elproyectegrande1.entity.Comment;
import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.mapper.CommentMapper;
import com.codecool.elproyectegrande1.repository.CommentRepository;
import com.codecool.elproyectegrande1.repository.DreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final DreamRepository dreamRepository;
    private final CommentMapper commentMapper;


    @Autowired
    public CommentService(CommentRepository commentRepository, DreamRepository dreamRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.dreamRepository = dreamRepository;
        this.commentMapper = commentMapper;
    }

    public CommentDto addComment(NewCommentDto newCommentDto, String username, Long dreamId) {
        Dream dream = dreamRepository.findById(dreamId)
                .orElseThrow(() -> new EntityNotFoundException("Dream not found"));
        Comment toBeSaved = commentMapper.mapNewCommentDtoToEntity(newCommentDto, username);
        toBeSaved.setDream(dream);
        Comment savedComment = commentRepository.save(toBeSaved);

        dream.getComments().add(toBeSaved);
        dreamRepository.save(dream);

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

    public List<CommentDto> getAllCommentsById(Long dreamId) {
        List<Comment> comments = commentRepository.findByDreamId(dreamId);

        List<CommentDto> commentDtos = new ArrayList<>();

        for (int i = 0; i < 8 && i < comments.size(); i++) {
            CommentDto dto = commentMapper.mapEntityToCommentDto(comments.get(i));
            commentDtos.add(dto);
        }

        return commentDtos;
    }

}
