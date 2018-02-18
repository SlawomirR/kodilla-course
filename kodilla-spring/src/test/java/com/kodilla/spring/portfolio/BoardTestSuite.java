package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        // Given

        String oneTaskToDoList = "and One_taskListString";
        List<String> tasksListToDoList = Arrays.asList("1. a", "2. b", "3. c");

        String oneTaskInProgressList = "and Two_tasksListString";
        List<String> tasksListInProgressList = Arrays.asList("d)", "e)", "f)");

        String oneTaskDoneList = "and Three_tasksListString";
        List<String> tasksListDoneList = Arrays.asList("G", "H", "I");

        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        TaskList toDoList = (TaskList)context.getBean("toDoList");
        TaskList inProgressList = (TaskList)context.getBean("inProgressList");
        TaskList doneList = (TaskList)context.getBean("doneList");

        // When
        board.setTasksListToDoList(tasksListToDoList);
        board.setStringToDoList(oneTaskToDoList);
        toDoList.addTask("last minute tasks");

        board.setTasksListInProgressList(tasksListInProgressList);
        board.setStringInProgressList(oneTaskInProgressList);
        inProgressList.addTask("and another special task");

        board.setTasksListDoneList(tasksListDoneList);
        board.setStringDoneList(oneTaskDoneList);
        board.getDoneList().getTasks().add("SILENTLY NOT ADDED BECAUSE OF READ ONLY METHOD. Is this OK??????????");
        doneList.addTask("archived task ;-)");
        // Then
        board.getToDoList().getTasks().stream().map(s -> s + System.getProperty("line.separator")).forEach(System.out::print);
        board.readTasksToDoList();

        System.out.println("=====================");
        board.getInProgressList().getTasks().stream().map(s -> s + System.getProperty("line.separator")).forEach(System.out::print);
        board.readTasksInProgressList();

        System.out.println("=====================");
        board.getDoneList().getTasks().stream().map(s -> s + System.getProperty("line.separator")).forEach(System.out::print);
        board.readTasksDoneList();
    }
}
