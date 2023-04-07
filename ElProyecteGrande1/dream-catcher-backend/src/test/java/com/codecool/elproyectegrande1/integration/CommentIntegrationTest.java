package com.codecool.elproyectegrande1.integration;

import com.codecool.elproyectegrande1.ElProyecteGrande1;
import com.codecool.elproyectegrande1.config.H2TestProfileJPAConfig;
import com.codecool.elproyectegrande1.entity.Comment;
import com.codecool.elproyectegrande1.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ElProyecteGrande1.class, H2TestProfileJPAConfig.class })
@ActiveProfiles("test")
public class CommentIntegrationTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void givenCommentRepository_whenSaveAndRetrieveEntity_thenOK() {
        Comment comment = commentRepository.save(new Comment("test", 0, "test"));
        Comment foundEntity = commentRepository.findById(comment.getId()).orElse(null);
        Assertions.assertNotNull(foundEntity);
        Assertions.assertEquals(comment.getCommentText(), foundEntity.getCommentText());
    }
}
