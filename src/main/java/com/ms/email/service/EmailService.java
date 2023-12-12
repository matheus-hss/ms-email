package com.ms.email.service;

import com.ms.email.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(EmailDTO emailDTO){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(username);
            simpleMailMessage.setTo(emailDTO.emailTo());
            simpleMailMessage.setSubject(emailDTO.subject());
            simpleMailMessage.setText(emailDTO.text());
            javaMailSender.send(simpleMailMessage);
        }catch(MailException ex){
            ex.getStackTrace();
        }
    }
}
