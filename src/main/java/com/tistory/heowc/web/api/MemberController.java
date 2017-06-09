package com.tistory.heowc.web.api;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.service.MemberService;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("api/member")
public class MemberController {

    @Resource(name = "proxyMemberService")
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<?> saveMember(@Valid @RequestBody Member member,
                                        BindingResult bindingResult) throws DuplicateMemberException,
                                                                            UnsupportedEncodingException {
        if ( bindingResult.hasErrors() ) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        return ResponseEntity.ok(memberService.validAndSave(member));
    }

    @PostMapping("search/password")
    public void searchPassword(@RequestBody Member member) {
        memberService.searchPassword(member);
    }
}
