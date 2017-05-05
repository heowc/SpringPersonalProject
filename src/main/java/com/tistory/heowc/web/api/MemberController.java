package com.tistory.heowc.web.api;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.service.MemberService;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/member")
public class MemberController {

    @Autowired MemberService memberService;

    @PostMapping
    public ResponseEntity<?> saveMember(@Valid @RequestBody Member member,
                                        BindingResult bindingResult) throws DuplicateMemberException {
        while(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                                .body(bindingResult.getAllErrors().get(0));
        }
        return ResponseEntity.ok(memberService.validAndSave(member));
    }
}
