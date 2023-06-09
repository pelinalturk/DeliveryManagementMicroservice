package com.pelin.boxservice.service;

import com.pelin.boxservice.model.DeliveryStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService{

    @Value("${spring.mail.username}")
    private String sender;

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendMail(String recipientMail, DeliveryStatus status) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(recipientMail);
        message.setText("Hello! This e-mail has been sent to inform you of your box status.\n" +
                "Status of your box: " + status);
        message.setSubject("Your Box Delivery Status");
        mailSender.send(message);
        return "mail is send";
    }
}
