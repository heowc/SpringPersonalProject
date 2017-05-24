package com.tistory.heowc.service.impl;

import com.tistory.heowc.domain.Comment;
import com.tistory.heowc.domain.Member;
import com.tistory.heowc.repository.CommentRepository;
import com.tistory.heowc.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Page<Comment> findCommentList(Integer page, Long noticeIdx) {
        return commentRepository.findAll(new PageRequest(page, 10));
    }

    @Override
    public Comment findCommentById(Long idx) {
        return commentRepository.findOne(idx);
    }

    @Override
    public void insert(Comment comment, UserDetails userDetails) {
        comment.setCreateDateTime(LocalDateTime.now());
        comment.setModifyDateTime(LocalDateTime.now());
        comment.setMember(new Member(userDetails));
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long idx, UserDetails userDetails) throws AccessDeniedException {
        if ( !matchByIdxAndPrincipal(idx, userDetails.getUsername()) ) {
            throw new AccessDeniedException("접근이 거부 되었습니다.");
        }
        commentRepository.delete(idx);
    }

    @Override
    public void update(Comment comment) {
        comment.setModifyDateTime(LocalDateTime.now());
        commentRepository.save(comment);
    }

    private boolean matchByIdxAndPrincipal(Long idx, Object principal) {
        Comment comment = commentRepository.findOne(idx);
        return principal.equals(comment.getMember().getEmail());
    }
}
