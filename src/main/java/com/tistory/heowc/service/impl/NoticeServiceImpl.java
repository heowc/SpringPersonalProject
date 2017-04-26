package com.tistory.heowc.service.impl;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.domain.mapper.NoticeDto;
import com.tistory.heowc.repository.NoticeRepository;
import com.tistory.heowc.service.NoticeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired NoticeRepository noticeRepository;

    @Autowired ModelMapper modelMapper;

    @Override
    public Page<NoticeDto.Notice> findNoticePaging(Integer page, String type, String keyword) {
        return findNoticeByConditions(page, type, keyword)
                .map(notice -> modelMapper.map(notice, NoticeDto.Notice.class));
    }

    @Override
    public Notice findNoticeById(Long idx) {
        return noticeRepository.findOne(idx);
    }

    @Override
    public void insert(Notice notice) {
        notice.setCreateDateTime(LocalDateTime.now());
        notice.setModifyDateTime(LocalDateTime.now());
        noticeRepository.save(notice);
    }

    @Override
    public void delete(Long idx) {
        noticeRepository.delete(idx);
    }

    @Override
    public void update(Notice notice) {
        notice.setModifyDateTime(LocalDateTime.now());
        noticeRepository.save(notice);
    }

    private Page<Notice> findNoticeByConditions(Integer page, String type, String keyword) {
        if("title".equals(type)) {
            return noticeRepository.findByTitleContaining(
                                        keyword,
                                        pageRequestByPage(page));
        }
        if("content".equals(type)) {
            return noticeRepository.findByContentContaining(
                                        keyword,
                                        pageRequestByPage(page));
        }
        return noticeRepository.findAll(pageRequestByPage(page));
    }

    private PageRequest pageRequestByPage(int page) {
        return new PageRequest(page, 10, new Sort(Sort.Direction.DESC, "createDateTime"));
    }
}
