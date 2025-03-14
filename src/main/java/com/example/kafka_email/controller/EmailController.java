package com.example.kafka_email.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka_email.model.EmailRequest;
import com.example.kafka_email.producer.EmailProducer;

@RestController
@RequestMapping("/api")
public class EmailController {
    private final EmailProducer emailProducer;

    public EmailController(EmailProducer emailProducer) {
        this.emailProducer = emailProducer;
    }

    //send email
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailProducer.sendEmailToKafka(emailRequest);
        return "Email sent successfully";
    }
}
