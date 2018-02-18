package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@org.springframework.boot.autoconfigure.SpringBootApplication
@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("toDoList")
    private TaskList toDoList;
    @Autowired
    @Qualifier("inProgressList")
    private TaskList inProgressList;
    @Autowired
    @Qualifier("doneList")
    private TaskList doneList;

    @Bean
    Board createBoard() {
        return new Board(toDoList, inProgressList, doneList);
    }

    @Bean(name = "toDoList")
    TaskList createToDoList() {
        toDoList = new TaskList();
        return toDoList;
    }

    @Bean(name = "inProgressList")
    TaskList createInProgressList() {
        inProgressList = new TaskList();
        return inProgressList;
    }

    @Bean(name = "doneList")
    TaskList createDoneList() {
        doneList = new TaskList();
        return doneList;
    }
}
