package com.demo.notificationservice.service;

import com.demo.notificationservice.request.SendSimpleMailMessageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final JavaMailSender javaMailSender;

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMailMessage(SendSimpleMailMessageRequest request) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(request.to());
        mailMessage.setText(request.content());
        mailMessage.setSubject(request.title());
        mailMessage.setFrom("e-commerce");

        javaMailSender.send(mailMessage);
    }
}
