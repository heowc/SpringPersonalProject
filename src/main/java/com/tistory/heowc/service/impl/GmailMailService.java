package com.tistory.heowc.service.impl;

import com.tistory.heowc.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("GmailMailService")
@Async
public class GmailMailService implements MailService {

    @Autowired JavaMailSender javaMailSender;

    @Override
    public void sendMail(String toEmail, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setFrom("heowc1992@gmail.com");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}
