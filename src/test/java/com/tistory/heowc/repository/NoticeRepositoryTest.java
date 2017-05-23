package com.tistory.heowc.repository;

import com.tistory.heowc.domain.Notice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Rollback(value = false)
public class NoticeRepositoryTest {

    @Autowired NoticeRepository noticeRepository;

    @Before
    public void before_init() throws Exception {
        noticeRepository.save(new Notice("title1", "content1"));
        noticeRepository.save(new Notice("title2", "content2"));
        noticeRepository.save(new Notice("title3", "content3"));
        noticeRepository.save(new Notice("title4", "content4"));
        noticeRepository.save(new Notice("title5", "content5"));
        noticeRepository.save(new Notice("title6", "content6"));
        noticeRepository.save(new Notice("title7", "content7"));
        noticeRepository.save(new Notice("title8", "content8"));
        noticeRepository.save(new Notice("title9", "content9"));
    }

    @Test
    public void test_findAll() throws Exception {
        noticeRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void test_findByTitleContaining() throws Exception {
        assertThat(noticeRepository.findByTitleContaining("1", pageRequest()).getContent().size())
                .isEqualTo(1);
    }

    @Test
    public void findByContentContaining() throws Exception {
        assertThat(noticeRepository.findByContentContaining("2", pageRequest()).getContent().size())
                .isEqualTo(1);
    }

    private PageRequest pageRequest() {
        return new PageRequest(0, 10);
    }
}