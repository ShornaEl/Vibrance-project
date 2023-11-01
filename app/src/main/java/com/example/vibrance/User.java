package com.example.vibrance;

public class User {
    String date,message;
    public User(){}
    public User(String date,String message) {
        this.message = message;
        this.date =date;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
