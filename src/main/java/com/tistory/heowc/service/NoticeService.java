package com.tistory.heowc.service;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.domain.mapper.NoticeDto;
import org.springframework.data.domain.Page;

public interface NoticeService {

    Page<NoticeDto.Notice> findNoticePaging(Integer page, String type, String keyword);
    Notice findNoticeById(Long idx);

    void insert(Notice content, String email);
    void delete(Long idx);
    void update(Notice notice);
}
