package com.tistory.heowc.service;

import com.tistory.heowc.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired CommentService commentService;

    @Test
    public void test_findCommentList() throws Exception {
        Page<Comment> comment = commentService.findCommentList(0, 1L);
        System.out.println(comment.toString());
        assertThat(comment.getSize()).isEqualTo(10);
        assertThat(comment.getContent().size()).isEqualTo(0);
    }

    @Test
    public void test_findCommentById() throws Exception {
        Comment comment = commentService.findCommentById(1L);
        assertThat(comment).isNull();
    }
}