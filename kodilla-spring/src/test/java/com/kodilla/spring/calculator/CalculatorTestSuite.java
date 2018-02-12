package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        // When
        double calcAdd = calculator.add(4.5, 5.5);
        double calcSub = calculator.sub(7, 3);
        double calcMul = calculator.mul(7, 3);
        double calcDiv = calculator.div(7, 2);
        // Then
        Assert.assertEquals(10, calcAdd, 0);
        Assert.assertEquals(4, calcSub, 0);
        Assert.assertEquals(21, calcMul, 0);
        Assert.assertEquals(3.5, calcDiv, 0);
    }
}
