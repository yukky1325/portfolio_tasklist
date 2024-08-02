package com.todojava.tasklist.main.entity;

public class TaskItem {
    String id;

    String client;
    String contractor;
    String task;

    String deadline;

    boolean done;

    public TaskItem(String id, String client, String contractor, String task, String deadline, boolean done) {
        this.id = id;
        this.client = client;
        this.contractor = contractor;
        this.task = task;
        this.deadline = deadline;
        this.done = done;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
