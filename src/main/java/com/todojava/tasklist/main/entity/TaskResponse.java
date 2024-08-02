package com.todojava.tasklist.main.entity;

public class TaskResponse {
    private String message;

    public TaskResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
