package com.mobai.manager.service.impl;

import com.mobai.manager.model.MailPO;
import com.mobai.manager.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl sender;

    @Override
    public void SendMail(MailPO mailPO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("manager@service.com");
        message.setTo(mailPO.getTo());
        message.setCc(mailPO.getCc());
        message.setSubject(mailPO.getSubject());
        message.setText(mailPO.getMessage());

        sender.send(message);
    }
}
