package com.tistory.heowc.web.api;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.service.MemberService;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("api/member")
public class MemberController {

    @Autowired MemberService memberService;

    @PostMapping
    public ResponseEntity<?> saveMember(@Valid @RequestBody Member member,
                                        BindingResult bindingResult) throws DuplicateMemberException,
                                                                            UnsupportedEncodingException {
        if ( bindingResult.hasErrors() ) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        return ResponseEntity.ok(memberService.validAndSave(member));
    }

    @GetMapping("reset/password")
    public void resetPassword(Authentication authentication) {
        memberService.resetPasswordAndSendMail(getUserDetails(authentication).getUsername());
    }

    private UserDetails getUserDetails(Authentication authentication) {
        return (UserDetails) authentication.getPrincipal();
    }
}
