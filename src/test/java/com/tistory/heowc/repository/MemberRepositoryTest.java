package com.tistory.heowc.repository;

import com.tistory.heowc.domain.Member;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Before
    public void before_init() throws Exception {
        memberRepository.save(new Member("heowc1992@gmail.com", "123412341234"));
    }

    @Test
    public void test_insert() throws Exception {
        Member member = memberRepository.save(new Member("heowc@gmail.com", "123412341234"));
        assertThat(member).isEqualTo(member);
    }

    @Test
    public void test_select() throws Exception {
        assertThat(memberRepository.findOne("heowc1992@gmail.com").getEmail())
                .isEqualTo("heowc1992@gmail.com");
    }
}