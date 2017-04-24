package com.tistory.heowc.service;

import com.tistory.heowc.domain.Member;
import javassist.bytecode.DuplicateMemberException;

public interface MemberService {

    public Member validAndSave(Member member) throws DuplicateMemberException;
}
