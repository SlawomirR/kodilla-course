package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTestSuite {
    @Autowired
    private TaskDao taskDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    public void testTaskDaoSave() {
        // Given
        int duration = 7;
        Task task = new Task(DESCRIPTION, duration);
        // When
        taskDao.save(task);
        // Then
        int id = task.getId();
        System.out.println(id);
        Task readTask = taskDao.findOne(id);
        System.out.println(readTask);
        Assert.assertEquals(id, readTask.getId());
        System.out.println(readTask.getId());
        // CleanUp
        taskDao.delete(id);
    }

    @Test
    public void testTaskDaoFindByDuration() {
        // Given
        int givenDuration = 7;
        Task task = new Task(DESCRIPTION, givenDuration);
        taskDao.save(task);
        int duration = task.getDuration();
        // When
        List<Task> readTasks = taskDao.findByDuration(duration);
        // Then
        Assert.assertEquals(1, readTasks.size());
        // CleanUp
        int id = readTasks.get(0).getId();
        taskDao.delete(id);
    }
}