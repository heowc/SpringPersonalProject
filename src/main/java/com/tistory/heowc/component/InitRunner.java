package com.tistory.heowc.component;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.repository.NoticeRepository;
import com.tistory.heowc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@Component
@Transactional
public class InitRunner implements CommandLineRunner {

    @Autowired MemberService memberService;
    @Autowired NoticeRepository noticeRepository;

    @Override
    public void run(String... args) throws Exception {
        final Member member = memberService.validAndSave(new Member("heowc1992@gmail.com", "1234"));

        IntStream.range(0, 15)
                .forEach(value -> noticeRepository.save(getNotice(member)));
    }

    private Notice getNotice(Member member) {
        Notice notice = new Notice("title", "content");
        notice.setMember(member);
        return notice;
    }
}
