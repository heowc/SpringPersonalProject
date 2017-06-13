package com.tistory.heowc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired MailService gmailMailService;

    @Test
    public void test_sendMail() throws Exception {
        gmailMailService.sendMail("heowc1992@gmail.com",
                                    "MailServiceTest",
                                    "MailServiceTest");
    }
}
