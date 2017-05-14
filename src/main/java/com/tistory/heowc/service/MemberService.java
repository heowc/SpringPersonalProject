package com.tistory.heowc.service;

import com.tistory.heowc.domain.Member;
import javassist.bytecode.DuplicateMemberException;

import java.io.UnsupportedEncodingException;

public interface MemberService {

    Member validAndSave(Member member) throws DuplicateMemberException, UnsupportedEncodingException;

    void resetPasswordAndSendMail(String toEmail);
}
