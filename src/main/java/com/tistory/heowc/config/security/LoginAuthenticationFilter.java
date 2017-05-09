package com.tistory.heowc.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tistory.heowc.domain.Member;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ObjectMapper objectMapper;
    private LoginAuthenticationHandler handler;

    public LoginAuthenticationFilter(ObjectMapper objectMapper, LoginAuthenticationHandler handler) {
        this.objectMapper = objectMapper;
        this.handler = handler;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        Member member = getMember(request);
        if (member != null) {
            return getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(member.getEmail(), member.getPassword()));
        } else {
            throw new InternalAuthenticationServiceException("Not Serializable Exception");
        }
    }

    private Member getMember(HttpServletRequest request) {
        try {
            Member member = objectMapper.readValue(request.getReader(), Member.class);
            System.out.println(member);
            member.toDecrypt();
            System.out.println(member);
            return member;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);
        handler.onAuthenticationSuccess(request, response, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        handler.onAuthenticationFailure(request, response, failed);
    }
}
