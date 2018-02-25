package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private final String whatToPaint;
    private final String color;
    private final String taskName;
    private boolean isDone;

    PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.isDone = false;
    }

    @Override
    public void executeTask() {
        isDone = true;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isDone;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }

    public String getColor() {
        return color;
    }
}
