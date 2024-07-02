package com.todojava.tasklist.main.entity;

public class HomeRestResponse {
    private String message;

    public HomeRestResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
