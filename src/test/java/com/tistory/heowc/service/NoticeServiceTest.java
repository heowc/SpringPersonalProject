package com.tistory.heowc.service;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.domain.mapper.NoticeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class NoticeServiceTest {

    @Autowired NoticeService noticeService;

    @Test
    public void test_findNoticePaging() throws Exception {
        Page<NoticeDto> notice = noticeService.findNoticePaging(1, "title", "");
        assertThat(notice.getSize()).isEqualTo(10);
    }

    @Test
    public void test_findNoticeById() throws Exception {
        Notice notice = noticeService.findNoticeById(1L);
        assertThat(notice.getTitle()).isEqualTo("title");
    }
}