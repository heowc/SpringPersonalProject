package com.tistory.heowc.component;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.repository.NoticeRepository;
import com.tistory.heowc.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@Component
@Transactional
@RequiredArgsConstructor
public class InitRunner implements CommandLineRunner {

    private final MemberService memberService;
    private final NoticeRepository noticeRepository;

    @Override
    public void run(String... args) throws Exception {
        Member member = new Member("heowc1992@gmail.com", "123412341234");

        memberService.validAndSave(member.applyEncode());

        IntStream.range(0, 15)
                .forEach(value -> noticeRepository.save(getNotice(member)));
    }

    private Notice getNotice(Member member) {
        Notice notice = new Notice("title", "content");
        notice.setMember(member);
        return notice;
    }
}
