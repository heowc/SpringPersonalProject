package com.tistory.heowc.web.api;

import com.tistory.heowc.domain.Comment;
import com.tistory.heowc.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("{idx}")
    public ResponseEntity<?> findCommentPage(@RequestParam(required = false, defaultValue = "0") Integer page,
                                            @RequestParam(required = false, defaultValue = "")   Long  noticeIdx) {
        return ResponseEntity.ok(commentService.findCommentList(page, noticeIdx));
    }

    @PostMapping
    public void insert(@RequestBody Comment comment,
                       Authentication authentication) {
        commentService.insert(comment, (UserDetails) authentication.getPrincipal());
    }

    @DeleteMapping("{idx}")
    public void delete(@PathVariable Long idx,
                       Authentication authentication) throws AccessDeniedException {
        commentService.delete(idx, (UserDetails) authentication.getPrincipal());
    }

    @PreAuthorize("(#comment.member.email == principal.username)")
    @PutMapping
    public void update(@RequestBody Comment comment) {
        commentService.update(comment);
    }
}
