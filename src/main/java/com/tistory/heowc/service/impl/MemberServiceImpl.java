package com.tistory.heowc.service.impl;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.repository.MemberRepository;
import com.tistory.heowc.service.MailService;
import com.tistory.heowc.service.MemberService;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService gmailMailService;

    @Override
    public Member validAndSave(Member member) throws DuplicateMemberException, UnsupportedEncodingException {
        member.applyDecode();

        if( memberRepository.exists(member.getEmail()) ) {
            throw new DuplicateMemberException(member.getEmail() + "는 이미 사용 중인 Email 입니다.");
        }

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.save(member);
    }

    @Override
    public void searchPassword(Member member) {
        Member searchMember = memberRepository.findOne(member.getEmail());

        if(searchMember != null) {
            String newPassword = getNewPassword();
            searchMember.setPassword(passwordEncoder.encode(newPassword));
            gmailMailService.sendMail(searchMember.getEmail(), "비밀번호 초기화 메일", newPassword);
        } else {
            throw new UsernameNotFoundException(member.getEmail() + "is not found");
        }
    }

    private String getNewPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
