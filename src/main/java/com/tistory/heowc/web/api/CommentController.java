package com.tistory.heowc.web.api;

import com.tistory.heowc.domain.Comment;
import com.tistory.heowc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    @Autowired CommentService service;

    @GetMapping("search")
    public ResponseEntity<?> findCommentPage(@RequestParam(required = false, defaultValue = "0") Integer page,
                                            @RequestParam(required = false, defaultValue = "")   Long  noticeIdx) {
        return ResponseEntity.ok(service.findCommentList(page, noticeIdx));
    }

    @GetMapping("{idx}")
    public ResponseEntity<?> findCommentById(@PathVariable Long idx) {
        return ResponseEntity.ok(service.findCommentById(idx));
    }

    @PostMapping
    public void insert(@RequestBody Comment comment,
                       Authentication authentication) {
        service.insert(comment, (UserDetails) authentication.getPrincipal());
    }

    @DeleteMapping("{idx}")
    public void delete(@PathVariable Long idx,
                       Authentication authentication) throws AccessDeniedException {
        service.delete(idx, (UserDetails) authentication.getPrincipal());
    }

    @PreAuthorize("(#comment.member.email == principal.username)")
    @PutMapping
    public void update(@RequestBody Comment comment) {
        service.update(comment);
    }
}
