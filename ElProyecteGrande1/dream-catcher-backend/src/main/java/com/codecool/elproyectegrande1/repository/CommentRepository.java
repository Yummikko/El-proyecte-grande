package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
