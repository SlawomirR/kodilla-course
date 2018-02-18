package com.kodilla.spring.portfolio;

import java.util.List;

final class Board {
    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public void setTasksListToDoList(List<String> addTasksToToDoList) {
        this.toDoList.addTasks(addTasksToToDoList);
    }

    public void setTasksListInProgressList(List<String> addTasksToInProgressList) {
        this.inProgressList.addTasks(addTasksToInProgressList);
    }

    public void setTasksListDoneList(List<String> addTasksToDoneList) {
        this.doneList.addTasks(addTasksToDoneList);
    }

    public void setStringToDoList(String addTaskToToDoList) {
        this.toDoList.addTask(addTaskToToDoList);
    }

    public void setStringInProgressList(String addTaskToInProgressList) {
        this.inProgressList.addTask(addTaskToInProgressList);
    }

    public void setStringDoneList(String addTaskToDoneList) {
        this.doneList.addTask(addTaskToDoneList);
    }

    public void readTasksToDoList() {
        System.out.println(toDoList.getTasks());
    }

    public void readTasksInProgressList() {
        System.out.println(inProgressList.getTasks());
    }

    public void readTasksDoneList() {
        System.out.println(doneList.getTasks());
    }
}
