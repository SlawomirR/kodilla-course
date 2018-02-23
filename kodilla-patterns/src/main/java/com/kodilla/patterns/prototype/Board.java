package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Set;

public final class Board extends Prototype {
    String name;
    private Set<TasksList> lists = new HashSet<>();

    Board(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Set<TasksList> getLists() {
        return lists;
    }

    void setLists(Set<TasksList> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Board [").append(name).append("]\n");
        for(TasksList list : lists) {
            stringBuilder.append(list.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board)super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board)super.clone();
        clonedBoard.lists = new HashSet<>();
        for(TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for(Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }
}
