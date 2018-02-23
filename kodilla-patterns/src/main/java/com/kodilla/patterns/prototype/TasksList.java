package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public final class TasksList {
    private final String name;
    private final List<Task> tasks = new ArrayList<>();

    TasksList(final String name) {
        this.name = name;
    }

    List<Task> getTasks() {
        return tasks;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("   List [" + name + "]");
        for(Task task : tasks) {
            string.append("\n").append(task.toString());
        }
        return string.toString();
    }
}
