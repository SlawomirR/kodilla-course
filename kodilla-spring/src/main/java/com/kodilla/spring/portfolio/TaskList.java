package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

final class TaskList {
    private List<String> tasks;

    TaskList() {
        tasks = new ArrayList<>();
    }

    List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    void addTasks(List<String> tasks) {
        this.tasks.addAll(tasks);
    }

    void addTask(String task) {
        this.tasks.add(task);
    }
}
