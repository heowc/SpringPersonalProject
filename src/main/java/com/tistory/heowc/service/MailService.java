package com.tistory.heowc.service;

public interface MailService {

    void sendMail(String toEmail, String subject, String message);
}
