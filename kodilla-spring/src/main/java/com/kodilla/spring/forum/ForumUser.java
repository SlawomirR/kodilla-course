package com.kodilla.spring.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class ForumUser {
    public static void main(String[] args) {
        SpringApplication.run(ForumUser.class, args);
    }
    private final String username;

    ForumUser() {
        username = "John Smith";
    }

    String getUsername() {
        return username;
    }

}
