package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class Calculator {
    double result;
    @Autowired
    private Display display;

    double add(double a, double b) {
        result = a + b;
        System.out.print("method add() => " + a + " + " + b + " = ");
        display.displayValue(result);
        return result;
    }

    double sub(double a, double b) {
        result = a - b;
        System.out.print("method sub() => " + a + " - " + b + " = ");
        display.displayValue(result);
        return result;
    }

    double mul(double a, double b) {
        result = a * b;
        System.out.print("method mul() => " + a + " * " + b + " = ");
        display.displayValue(result);
        return result;
    }

    double div(double a, double b) {
        result = a / b;
        System.out.print("method div() => " + a + " / " + b + " = ");
        display.displayValue(result);
        return result;
    }
}
