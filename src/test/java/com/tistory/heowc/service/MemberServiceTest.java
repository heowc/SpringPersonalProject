package com.tistory.heowc.service;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void test_validAndSave() throws Exception {
        Member member = memberService.validAndSave(new Member("heowc@gmail.com", "123412341234")
                                                    .toEncrypt());
        assertThat(member)
                .isEqualTo(memberRepository.findOne("heowc@gmail.com"));
    }

    @Test
    public void test_resetPasswordAndSendMail() throws Exception {
        memberService.resetPasswordAndSendMail("heowc1992@gmail.com");
        assertThat("123412341234")
                .isNotEqualTo(memberRepository.findOne("heowc1992@gmail.com").getPassword());
    }
}