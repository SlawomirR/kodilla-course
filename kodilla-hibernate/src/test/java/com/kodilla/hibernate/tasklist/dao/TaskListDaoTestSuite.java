package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;

    @Test
    public void testTaskListDaoSaveWithTasks() {
        // Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList("LISTNAME", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);
        // When
        taskListDao.save(taskList);
        int id = taskList.getId();
        // Then
        Assert.assertNotEquals(0, id);
        // CleanUp
        taskListDao.delete(id);
    }

    @Test
    public void testFindByListName() {
        // Given
        String descToDo = "This is toDo list";
        TaskList taskList = new TaskList("toDoList", descToDo);
        long numberOrig = taskListDao.count();
        taskListDao.save(taskList);
        int idToDo = taskList.getId();
        // When
        List<TaskList> readTaskLists = taskListDao.findByListName("toDoList");
        // Then
        Assert.assertEquals(1, readTaskLists.size());
        // CleanUp
        taskListDao.delete(idToDo);
        long numberAfter = taskListDao.count();
        Assert.assertEquals(("We have: " + numberAfter + "instead of " + numberOrig), numberOrig, numberAfter);
    }
}
