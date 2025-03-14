package com.example.kafka_email.consumer;

import com.example.kafka_email.model.EmailRequest;
import com.example.kafka_email.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailConsumer {
    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    public EmailConsumer(EmailService emailService, ObjectMapper objectMapper) {
        this.emailService = emailService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "email-topic", groupId = "group_id")
    public void consumeEmail(String message) {
        try {
            EmailRequest emailRequest = objectMapper.readValue(message, EmailRequest.class);
            emailService.sendEmail(emailRequest);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
