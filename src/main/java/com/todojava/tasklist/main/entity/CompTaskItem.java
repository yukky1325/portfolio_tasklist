package com.todojava.tasklist.main.entity;

import java.time.LocalDateTime;

public class CompTaskItem {
    String id;

    String client;
    String contractor;
    String task;

    String deadline;
    LocalDateTime completedDate;

    public CompTaskItem(String id, String client, String contractor, String task, String deadline, LocalDateTime completedDate) {
        this.id = id;
        this.client = client;
        this.contractor = contractor;
        this.task = task;
        this.deadline = deadline;
        this.completedDate = completedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }
}
