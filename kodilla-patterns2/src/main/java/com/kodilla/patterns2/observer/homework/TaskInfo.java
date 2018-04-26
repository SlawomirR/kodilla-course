package com.kodilla.patterns2.observer.homework;

public class TaskInfo {
    private String taskUrl;
    private TaskStatus taskStatus;

    TaskInfo(String taskUrl, TaskStatus taskStatus) {
        this.taskUrl = taskUrl;
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                ", taskUrl='" + taskUrl + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }

    void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
