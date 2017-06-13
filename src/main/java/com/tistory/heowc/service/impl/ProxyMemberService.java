package com.tistory.heowc.service.impl;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.service.MemberService;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class ProxyMemberService implements MemberService {

    private final MemberService memberServiceImpl;
    private final RedisTemplate<String, Member> memberRedisTemplate;

    @Override
    public Member validAndSave(Member member) throws DuplicateMemberException, UnsupportedEncodingException {
        member.applyDecode();

        if ( memberRedisTemplate.opsForValue().get(member.getEmail()) != null ) {
            throw new DuplicateMemberException(member.getEmail() + "는 이미 사용 중인 Email 입니다.");
        }

        memberRedisTemplate.opsForValue().set(member.getEmail(), member);
        member.applyEncode();

        return memberServiceImpl.validAndSave(member);
    }

    @Override
    public void searchPassword(Member member) {
        memberServiceImpl.searchPassword(member);
    }
}
