package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTestSuite {
    @Autowired
    private TaskDao taskDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    public void testTaskDaoSaveWithFinancialDetails() {
        //Given
        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));
        //When
        taskDao.save(task);
        int id = task.getId();
        // Then
        try {
            Assert.assertNotEquals(0, id);
        } finally {
            // CleanUp
            if (taskDao.existsById(id)) {
                System.out.println(taskDao.findById(id));
                taskDao.deleteById(id);
            }
        }
    }

    @Test
    public void testTaskDaoSave() {
        // Given
        int duration = 7;
        Task task = new Task(DESCRIPTION, duration);
        taskDao.save(task);
        int id = task.getId();
        System.out.println(id);
        // When
        Optional<Task> readTask = taskDao.findById(id);
        System.out.println(readTask);
        // Then
        try {
            Assert.assertEquals(id, readTask.get().getId());
            System.out.println(readTask.get().getId());
        } finally {
            // CleanUp
            if (taskDao.existsById(id)) {
                System.out.println(" ===> We have ID: " + id);
                System.out.println(taskDao.findById(id));
                taskDao.deleteById(id);
            }
        }
    }

    @Test
    public void testTaskDaoFindByDuration() {
        // Given
        int givenDuration = 7;

        Task task = new Task(DESCRIPTION, givenDuration);
        taskDao.save(task);
        int id = task.getId();

        int duration = task.getDuration();
        // When
        List<Task> readTasks = taskDao.findByDuration(duration);
        // Then
        try {
            Assert.assertEquals(1, readTasks.size());
            Assert.assertEquals(givenDuration, readTasks.get(0).getDuration());
        } finally {
            // CleanUp
            if (taskDao.existsById(id)) {
                System.out.println(" ===> We have ID: " + id);
                System.out.println(taskDao.findById(id));
                taskDao.deleteById(id);
            }
        }
    }
}
