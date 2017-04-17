package com.tistory.heowc.component;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InitRunner implements CommandLineRunner {

    @Autowired NoticeService noticeService;

    @Override
    public void run(String... args) throws Exception {
        Notice notice = new Notice("Spring Personal Project",
                                    "Spring Personal Project",
                                    "won chul");
        noticeService.insert(notice);
    }
}
