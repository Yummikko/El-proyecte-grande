package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.comment.CommentDto;
import com.codecool.elproyectegrande1.entity.Comment;
import com.codecool.elproyectegrande1.mapper.CommentMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    private CommentMapper commentMapper;
    @Mock
    private CommentService commentService;


    @Test
    void shouldMapEntityToCommentDto() {
        Comment comment = new Comment("Test", 0, "Test");
        comment.setId(1L);
        comment.setTimeCreated(LocalDateTime.of(2018, Month.NOVEMBER,11, 11, 11));
        comment.setTimeCreated(LocalDateTime.now());

        CommentDto actual = commentMapper.mapEntityToCommentDto(comment);
        Assertions.assertNotNull(actual);

        Assertions.assertEquals(comment.getId(), actual.getId());
        Assertions.assertEquals(comment.getCommentText(), actual.getComment());
        Assertions.assertEquals(comment.getLikes(), actual.getLikes());
        Assertions.assertEquals(comment.getUsername(), actual.getUsername());
        Assertions.assertEquals(comment.getTimeUpdated(), actual.getUpdatedDate());
    }

}