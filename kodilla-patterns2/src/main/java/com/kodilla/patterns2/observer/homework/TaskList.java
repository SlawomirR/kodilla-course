package com.kodilla.patterns2.observer.homework;

public enum TaskList {
    INTRO("1. Introduction"),
    STEP1("2. New Information"),
    STEP2("3. Explanation"),
    STEP3("4. Conclusion");

    private String taskName;

    TaskList(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}
