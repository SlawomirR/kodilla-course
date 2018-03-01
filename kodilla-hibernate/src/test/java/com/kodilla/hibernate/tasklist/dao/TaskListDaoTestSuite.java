package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;

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
