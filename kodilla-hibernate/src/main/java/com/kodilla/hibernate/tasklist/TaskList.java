package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "TASKLISTS")
public class TaskList {
    private int id;
    private String listName;
    private String description;
    private List<Task> tasks = new ArrayList<>();

    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
