package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.CommentDto;
import com.codecool.elproyectegrande1.dto.NewCommentDto;
import com.codecool.elproyectegrande1.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentDto mapEntityToCommentDto(Comment entity) {
        return new CommentDto(
                entity.getId(),
                entity.getComment(),
                entity.getCreatedDate(),
                entity.getUpdatedDate(),
                entity.getLikes()
        );
    }

    public Comment mapNewCommentDtoToEntity(NewCommentDto dto) {
        return new Comment(
                dto.getComment(),
                0
        );
    }
}
