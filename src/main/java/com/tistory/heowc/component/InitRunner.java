package com.tistory.heowc.component;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.repository.MemberRepository;
import com.tistory.heowc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@Component
@Transactional
public class InitRunner implements CommandLineRunner {

    @Autowired MemberRepository memberRepository;
    @Autowired NoticeService noticeService;

    @Override
    public void run(String... args) throws Exception {
        final Member member = memberRepository.save(new Member("heowc1992@gmail.com"));

        IntStream.range(0, 15)
                .forEach(value -> noticeService.insert(new Notice("title", "content", member)));
    }
}
