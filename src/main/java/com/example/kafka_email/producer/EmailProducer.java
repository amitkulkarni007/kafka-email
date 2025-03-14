package com.example.kafka_email.producer;

import com.example.kafka_email.config.KafkaConfig;
import com.example.kafka_email.model.EmailRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public EmailProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendEmailToKafka(EmailRequest emailRequest) {
        try {
            String message = objectMapper.writeValueAsString(emailRequest);
            kafkaTemplate.send(KafkaConfig.TOPIC_NAME, message);
        } catch (JsonProcessingException e) {
            System.out.println(e.toString());
        }
    }
}
