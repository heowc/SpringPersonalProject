package com.tistory.heowc.repository;

import com.tistory.heowc.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
@Rollback(value = false)
public class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;

    @Test
    public void test_insert() throws Exception {
        commentRepository.save(testComment());
    }

    @Test
    public void test_select() throws Exception {
        commentRepository.saveAndFlush(testComment());
        commentRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void test_update() throws Exception {
        Comment comment = commentRepository.saveAndFlush(testComment());
        comment.setContent("comment2");
    }

    @Test
    public void test_delete() throws Exception {
        Comment comment = commentRepository.saveAndFlush(testComment());
        commentRepository.delete(comment);
    }

    private Comment testComment() {
        Comment comment = new Comment();
        comment.setContent("comment");
        comment.setCreateDateTime(LocalDateTime.now());
        comment.setModifyDateTime(LocalDateTime.now());
        return comment;
    }
}