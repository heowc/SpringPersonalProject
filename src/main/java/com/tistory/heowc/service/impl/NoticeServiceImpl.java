package com.tistory.heowc.service.impl;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.repository.NoticeRepository;
import com.tistory.heowc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired NoticeRepository repository;

    @Override
    public void insert(Notice notice) {
        repository.save(notice);
    }

    @Override
    public void delete(Long idx) {
        repository.delete(idx);
    }

    @Override
    public void update(Notice notice) {
        notice.setModifyDateTime(LocalDateTime.now());
        repository.save(notice);
    }

    @Override
    public Page<Notice> getNotice(Integer page, String type, String keyword) {
        return repository.findAll(new PageRequest(page, 10));
    }
}
