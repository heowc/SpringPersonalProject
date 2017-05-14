package com.tistory.heowc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityTest {

    @Test
    @WithMockUser(username="heowc1992@gmail.com", password = "123412341234")
    public void test_withMockUser() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) authentication.getPrincipal()).getUsername();

        assertThat(username).isEqualTo("heowc1992@gmail.com");
    }

    @Test
    @WithUserDetails(value="heowc1992@gmail.com")
    public void test_userDetailsService() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) authentication.getPrincipal()).getUsername();

        assertThat(username).isEqualTo("heowc1992@gmail.com");
    }
}
