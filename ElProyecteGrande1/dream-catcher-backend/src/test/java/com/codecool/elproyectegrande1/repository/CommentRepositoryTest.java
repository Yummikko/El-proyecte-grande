package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = { ElProyecteGrande1.class, H2TestProfileJPAConfig.class })
//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class CommentRepositoryTest {
    @Mock
    private CommentRepository commentRepository;

    @Test
    void givenCommentRepository_whenSaveAndRetrieveEntity_thenOK() {
        Comment comment = commentRepository.save(new Comment("test", 0, "test"));
        comment.setId(1L);
        Comment foundEntity = commentRepository.findById(comment.getId()).orElse(null);
        Assertions.assertNotNull(foundEntity);
        Assertions.assertEquals(comment.getCommentText(), foundEntity.getCommentText());
    }
}