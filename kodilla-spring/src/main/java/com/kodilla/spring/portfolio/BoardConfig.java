package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    @Bean
    Board createBoard() {
        return new Board(createToDoList(), createInProgressList(), createDoneList());
    }

    @Bean
    TaskList createToDoList() {
        return new TaskList();
    }

    @Bean
    TaskList createInProgressList() {
        return new TaskList();
    }

    @Bean
    TaskList createDoneList() {
        return new TaskList();
    }
}
