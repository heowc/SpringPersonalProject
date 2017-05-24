package com.tistory.heowc.config.security;

import com.tistory.heowc.domain.Member;
import com.tistory.heowc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Member member = memberRepository.findOne(username);

        if(member == null) {
            throw new UsernameNotFoundException(username + "is not found");
        }

        return new User(member.getEmail(),
                        member.getPassword(),
                        AuthorityUtils.createAuthorityList("USER"));
    }
}
