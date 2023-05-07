package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.comment.CommentDto;
import com.codecool.elproyectegrande1.dto.comment.NewCommentDto;
import com.codecool.elproyectegrande1.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentDto mapEntityToCommentDto(Comment entity) {
        return new CommentDto(
                entity.getId(),
                entity.getComment(),
                entity.getTimeCreated(),
                entity.getTimeUpdated(),
                entity.getLikes(),
                entity.getUsername()
        );
    }

    public Comment mapNewCommentDtoToEntity(NewCommentDto dto, String username) {
        return new Comment(
                dto.getComment(),
                0,
                username
        );
    }
}
