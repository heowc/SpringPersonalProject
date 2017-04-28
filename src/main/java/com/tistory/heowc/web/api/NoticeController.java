package com.tistory.heowc.web.api;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.domain.mapper.NoticeDto;
import com.tistory.heowc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("api/notice")
public class NoticeController {

    @Autowired NoticeService service;

    @GetMapping("search")
    public Page<NoticeDto.Notice> findNoticePage(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                  @RequestParam(required = false, defaultValue = "")  String  type,
                                                  @RequestParam(required = false, defaultValue = "")  String  keyword) {
        return service.findNoticePaging(page, type, keyword);
    }

    @GetMapping("{idx}")
    public Notice findNoticeById(@PathVariable Long idx) {
        return service.findNoticeById(idx);
    }

    @PostMapping
    public void insert(@RequestBody Notice notice, Authentication authentication) {
        service.insert(notice, (String) authentication.getPrincipal());
    }

    @DeleteMapping("{idx}")
    public void delete(@PathVariable Long idx, Authentication authentication) throws AccessDeniedException {
        service.delete(idx, authentication);
    }

    @PreAuthorize("(#notice.member.email == principal.username)")
    @PutMapping
    public void update(@RequestBody Notice notice) {
        service.update(notice);
    }


}
