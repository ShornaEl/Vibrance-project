package com.example.vibrance;

public class Message {
    private String date;
    private String message;

    public Message() {
        // Default constructor required for Firestore
    }

    public Message(String date, String message) {
        this.date = date;
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
