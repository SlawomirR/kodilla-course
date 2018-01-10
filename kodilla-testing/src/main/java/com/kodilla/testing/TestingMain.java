package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        Calculator calculator = new Calculator();

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");
        if (calculator.add(2, 2) == 4) {
            System.out.println("test for ADD is OK");
        } else {
            System.out.println("test for ADD failed!");
        }

        if (calculator.subtract(6, 2) == 4) {
            System.out.println("test for SUBTRACT is OK");
        } else {
            System.out.println("test for SUBTRACT failed!");
        }
    }
}

