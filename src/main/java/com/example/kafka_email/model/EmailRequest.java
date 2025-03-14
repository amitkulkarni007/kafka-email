package com.example.kafka_email.model;

public class EmailRequest {
    private String to;
    private String subject;
    private String message;

    //getter and setter
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    //setter set message
    public void setMessage(String message) {
        this.message = message;
    }

    //getter get message
    public String getMessage() {
        return message;
    }

    //setter set to
    public void setTo(String to) {
        this.to = to;
    }
    //getter get to
    public String getTo() {
        return to;
    }
}
