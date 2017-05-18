package com.tistory.heowc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Resource(name = "GmailMailService") MailService mailService;

    @Test
    public void test_sendMail() throws Exception {
        mailService.sendMail("heowc1992@gmail.com", "MailServiceTest");
    }
}
