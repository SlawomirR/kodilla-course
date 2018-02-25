package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryCircle() {
        // Given
        TaskFactory taskFactory = new TaskFactory();
        // When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING_TASK);
        shoppingTask.executeTask();
        // Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Food", shoppingTask.getTaskName());
    }

    @Test
    public void testFactorySquare() {
        // Given
        TaskFactory taskFactory = new TaskFactory();
        // When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTING_TASK);
        paintingTask.executeTask();
        // Then
        Assert.assertTrue(paintingTask.isTaskExecuted());
        Assert.assertEquals("Paint", paintingTask.getTaskName());
    }

    @Test
    public void testFactoryRectangle() {
        // Given
        TaskFactory taskFactory = new TaskFactory();
        // When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVING_TASK);
        drivingTask.executeTask();
        // Then
        Assert.assertTrue(drivingTask.isTaskExecuted());
        Assert.assertEquals("Morning", drivingTask.getTaskName());
    }
}
