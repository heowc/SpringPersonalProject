package com.tistory.heowc.service;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.domain.mapper.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;

import java.nio.file.AccessDeniedException;

public interface NoticeService {

    Page<NoticeDto.Notice> findNoticePaging(Integer page, String type, String keyword);
    Notice findNoticeById(Long idx);

    void insert(Notice content, String email);
    void delete(Long idx, Authentication authentication) throws AccessDeniedException;
    void update(Notice notice);
}
