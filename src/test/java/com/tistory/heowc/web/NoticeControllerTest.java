package com.tistory.heowc.web;

import com.tistory.heowc.service.NoticeService;
import com.tistory.heowc.web.api.NoticeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(NoticeController.class)
public class NoticeControllerTest {

    @Autowired MockMvc mvc;
    @MockBean NoticeService noticeService;

    @Test
    @WithMockUser(username="heowc1992@gmail.com", password = "1234")
    public void test_findNoticePage() throws Exception {
        int statusCode = mvc.perform(get("/api/notice/search").accept(MediaType.APPLICATION_JSON_UTF8))
                               .andReturn().getResponse().getStatus();

        assertThat(statusCode).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void test_notAuthorityFindNoticePage() throws Exception {
        int statusCode = mvc.perform(get("/api/notice/search").accept(MediaType.APPLICATION_JSON_UTF8))
                            .andReturn().getResponse().getStatus();

        assertThat(statusCode).isEqualTo(HttpStatus.UNAUTHORIZED.value());
    }

    @Test
    @WithMockUser(username="heowc1992@gmail.com", password = "1234")
    public void test_deleteByIdx() throws Exception {
        int statusCode = mvc.perform(delete("/api/notice/1"))
                .andReturn().getResponse().getStatus();

        assertThat(statusCode).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void test_notAuthorityDeleteByIdx() throws Exception {
        int statusCode = mvc.perform(delete("/api/notice/1"))
                .andReturn().getResponse().getStatus();

        assertThat(statusCode).isEqualTo(HttpStatus.UNAUTHORIZED.value());
    }
}
