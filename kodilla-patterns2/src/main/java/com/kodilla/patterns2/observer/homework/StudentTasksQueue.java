package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTasksQueue implements StudentTaskObservable {
    private List<MentorsObserver> observers;
    private Map<String, TaskInfo> taskInfo;
    private String studentName;

    StudentTasksQueue(String studentName) {
        observers = new ArrayList<>();
        this.studentName = studentName;
        taskInfo = new HashMap<>();
        for (TaskList taskList : TaskList.values()) {
            taskInfo.put(taskList.getTaskName(), new TaskInfo("", TaskStatus.NEW));
        }
    }
    void sendTask(TaskList taskName, String taskUrl) {
        taskInfo.get(taskName.getTaskName()).setTaskUrl(taskUrl);
        taskInfo.get(taskName.getTaskName()).setTaskStatus(TaskStatus.PENDING);
        notifyMentors();
    }

    @Override
    public void registerMentor(MentorsObserver mentorsObserver) {
        observers.add(mentorsObserver);
    }

    @Override
    public void notifyMentors() {
        for (MentorsObserver observer : observers) {
            observer.changeTaskStatus(this);
        }
    }

    @Override
    public void removeMentor(MentorsObserver mentorsObserver) {
        observers.remove(mentorsObserver);
    }
}
