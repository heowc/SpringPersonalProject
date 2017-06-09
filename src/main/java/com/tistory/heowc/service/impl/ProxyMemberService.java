package com.tistory.heowc.service.impl;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.service.MemberService;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Service("proxyMemberService")
public class ProxyMemberService implements MemberService {

    @Resource(name = "memberServiceImpl")
    private MemberService memberService;

    @Resource(name = "memberRedisTemplate")
    private ValueOperations<String, Member> memberOps;

    @Override
    public Member validAndSave(Member member) throws DuplicateMemberException, UnsupportedEncodingException {
        member.applyDecode();

        if ( memberOps.get(member.getEmail()) != null) {
            throw new DuplicateMemberException(member.getEmail() + "는 이미 사용 중인 Email 입니다.");
        }

        memberOps.set(member.getEmail(), member);
        member.applyEncode();

        return memberService.validAndSave(member);
    }

    @Override
    public void searchPassword(Member member) {
        memberService.searchPassword(member);
    }
}
