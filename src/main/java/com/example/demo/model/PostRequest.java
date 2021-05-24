package com.example.demo.model;

public class PostRequest {
    private final String title;
    private final String message;

    public PostRequest(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}