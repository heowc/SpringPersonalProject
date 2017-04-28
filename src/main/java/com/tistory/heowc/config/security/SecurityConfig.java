package com.tistory.heowc.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired ObjectMapper objectMapper;
    @Autowired LoginAuthenticationHandler loginAuthenticationHandler;
    @Autowired LogoutHandler logoutHandler;

    private static final String BASE_END_POINT = "/notice";
    private static final String LOGIN_END_POINT = "/login";
    private static final String LOGOUT_END_POINT = "/logout";
    private static final String JOIN_END_POINT = "/api/member";

    private static final String RESOURCE_END_POINT = "/resources/**";
    private static final String WEBJARS_END_POINT = "/webjars/**";
    private static final String APP_END_POINT = "/app/**";

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(RESOURCE_END_POINT, WEBJARS_END_POINT, APP_END_POINT);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilter(usernamePasswordAuthenticationFilter())
            .authorizeRequests()
                .antMatchers(BASE_END_POINT, LOGOUT_END_POINT, LOGIN_END_POINT).permitAll()
                .antMatchers(HttpMethod.POST, JOIN_END_POINT).permitAll()
    			.antMatchers("/api/**").authenticated()
                .antMatchers("/**").permitAll()
                .and()
    		.formLogin()
                .loginPage(BASE_END_POINT)
                .loginProcessingUrl(LOGIN_END_POINT)
                .and()
    		.logout()
                .logoutUrl(LOGOUT_END_POINT)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutHandler)
                .invalidateHttpSession(true)
                .and()
    		.csrf().disable();
    }

    private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
        UsernamePasswordAuthenticationFilter filter = new LoginAuthenticationFilter(objectMapper, loginAuthenticationHandler);
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }
}
