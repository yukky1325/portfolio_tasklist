package com.todojava.tasklist.main.entity;

public class TaskItem {
    String id;

    String task;

    String deadline;

    boolean done;

    public TaskItem(String id, String task, String deadline, boolean done) {
        this.id = id;
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
