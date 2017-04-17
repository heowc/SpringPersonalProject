package com.tistory.heowc.service;

import com.tistory.heowc.domain.Notice;
import org.springframework.data.domain.Page;

public interface NoticeService {

    Page<Notice> findNoticePaging(Integer page, String type, String keyword);
    Notice findNoticeById(Long idx);

    void insert(Notice notice);
    void delete(Long idx);
    void update(Notice notice);
}
