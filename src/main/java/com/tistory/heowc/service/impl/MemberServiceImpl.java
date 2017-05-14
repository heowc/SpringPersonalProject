package com.tistory.heowc.service.impl;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.repository.MemberRepository;
import com.tistory.heowc.service.MailService;
import com.tistory.heowc.service.MemberService;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired MemberRepository memberRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @Resource(name = "GmailMailService") MailService mailService;

    @Override
    public Member validAndSave(Member member) throws DuplicateMemberException, UnsupportedEncodingException {
        member.toDecrypt();

        if( memberRepository.exists(member.getEmail()) ) {
            throw new DuplicateMemberException(member.getEmail() + "는 이미 사용 중인 Email 입니다.");
        }

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.saveAndFlush(member);
    }

    @Override
    public void resetPasswordAndSendMail(String toEmail) {
        Member member = memberRepository.findOne(toEmail);
        String newPassword = UUID.randomUUID().toString().substring(0, 8);
        member.setPassword(passwordEncoder.encode(newPassword));
        mailService.sendMail(toEmail, newPassword);
    }
}
