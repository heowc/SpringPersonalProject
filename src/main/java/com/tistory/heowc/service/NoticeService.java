package com.tistory.heowc.service;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.domain.mapper.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.file.AccessDeniedException;

public interface NoticeService {

    Page<NoticeDto> findNoticeDtoList(Integer page, String type, String keyword);
    Notice findNoticeById(Long idx);

    void insert(Notice content);
    void delete(Long idx, UserDetails userDetails) throws AccessDeniedException;
    void update(Notice notice);
}
