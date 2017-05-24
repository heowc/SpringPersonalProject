package com.tistory.heowc.web.api;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.service.CommentService;
import com.tistory.heowc.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("api/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    private final CommentService commentService;

    @GetMapping("search")
    public ResponseEntity<?> findNoticePage(@RequestParam(required = false, defaultValue = "0") Integer page,
                                            @RequestParam(required = false, defaultValue = "")  String  type,
                                            @RequestParam(required = false, defaultValue = "")  String  keyword) {
        return ResponseEntity.ok(noticeService.findNoticeDtoList(page, type, keyword));
    }

    @GetMapping("{idx}")
    public ResponseEntity<?> findNoticeById(@PathVariable Long idx) {
        return ResponseEntity.ok(noticeService.findNoticeById(idx));
    }

    @PostMapping
    public void insert(@RequestBody Notice notice,
                       Authentication authentication) {
        noticeService.insert(notice, (UserDetails) authentication.getPrincipal());
    }

    @DeleteMapping("{idx}")
    public void delete(@PathVariable Long idx,
                       Authentication authentication) throws AccessDeniedException {
        noticeService.delete(idx, (UserDetails) authentication.getPrincipal());
    }

    @PreAuthorize("(#notice.member.email == principal.username)")
    @PutMapping
    public void update(@RequestBody Notice notice) {
        noticeService.update(notice);
    }

    @GetMapping("{idx}/comment")
    public ResponseEntity<?> findCommentPage(@RequestParam(required = false, defaultValue = "0") Integer page,
                                             @RequestParam(required = false, defaultValue = "")   Long  noticeIdx) {
        return ResponseEntity.ok(commentService.findCommentList(page, noticeIdx));
    }
}
