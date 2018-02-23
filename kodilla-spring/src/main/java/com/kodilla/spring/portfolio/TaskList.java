package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

final class TaskList {
    private List<String> tasks;

    TaskList() {
        tasks = new ArrayList<>();
    }

    List<String> getTasks() {
        return tasks;
    }
}
