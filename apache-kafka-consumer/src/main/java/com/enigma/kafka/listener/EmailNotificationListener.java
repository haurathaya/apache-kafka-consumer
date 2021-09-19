package com.enigma.kafka.listener;

import com.enigma.kafka.model.Email;
import com.enigma.kafka.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @Autowired
    EmailService emailService;

    @KafkaListener(id = "foo", topics = "kafka-training")
    public void listener(String foo) {
        System.out.println(foo);
        Email email = new Email("sweetbliss2000@gmail.com", "haura.athaya@gmail.com", "Enigma Book Store - Transaction Notification", foo);
        emailService.sendMail(email);
    }
}
