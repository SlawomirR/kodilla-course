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

        // When
        board.getToDoList().getTasks().addAll(tasksListToDoList);
        board.getToDoList().getTasks().add(oneTaskToDoList);

        board.getInProgressList().getTasks().addAll(tasksListInProgressList);
        board.getInProgressList().getTasks().add(oneTaskInProgressList);

        board.getDoneList().getTasks().addAll(tasksListDoneList);
        board.getDoneList().getTasks().add(oneTaskDoneList);
        // Then
        board.getToDoList().getTasks().stream().map(s -> s + System.getProperty("line.separator")).forEach(System.out::print);

        System.out.println("=====================");
        board.getInProgressList().getTasks().stream().map(s -> s + System.getProperty("line.separator")).forEach(System.out::print);

        System.out.println("=====================");
        board.getDoneList().getTasks().stream().map(s -> s + System.getProperty("line.separator")).forEach(System.out::print);
    }
}
