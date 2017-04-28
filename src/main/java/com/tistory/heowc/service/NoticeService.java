package com.tistory.heowc.service;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.domain.mapper.NoticeDto;
import org.springframework.data.domain.Page;

import java.nio.file.AccessDeniedException;

public interface NoticeService {

    Page<NoticeDto.Notice> findNoticePaging(Integer page, String type, String keyword);
    Notice findNoticeById(Long idx);

    void insert(Notice content);
    void delete(Long idx) throws AccessDeniedException;
    void update(Notice notice);
}
