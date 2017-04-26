package com.tistory.heowc.web;

import com.tistory.heowc.service.NoticeService;
import com.tistory.heowc.web.api.NoticeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(NoticeController.class)
public class NoticeControllerTest {

    @Autowired MockMvc mvc;
    @MockBean NoticeService noticeService;

    @Test
    public void test_findNoticePage() throws Exception {
    }
}
