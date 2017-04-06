package com.tistory.heowc.service;

import com.tistory.heowc.domain.Notice;
import org.springframework.data.domain.Page;

public interface NoticeService {

    void insert(Notice notice);
    void delete(Long idx);
    void update(Notice notice);

    Page<Notice> getNotice(Integer page, String type, String keyword);
}
