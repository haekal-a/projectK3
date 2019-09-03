package com.example.basicauth;

/**
 * Created by Reza Pahlevie on 25/08/2019.
 */
public class AuthModel {

    private String message;
    private String title;

    public AuthModel(String message, String title) {
        this.message = message;
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "AuthModel{" +
                "message='" + message + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
