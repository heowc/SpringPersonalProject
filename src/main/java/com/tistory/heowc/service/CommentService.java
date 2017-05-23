package com.tistory.heowc.service;

import com.tistory.heowc.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;

public interface CommentService {

    Page<Comment> findCommentList(Integer page, Long noticeIdx);
    Comment findCommentById(Long idx);

    void insert(Comment comment, UserDetails userDetails);
    void delete(Long idx, UserDetails userDetails) throws AccessDeniedException;
    void update(Comment comment);
}
