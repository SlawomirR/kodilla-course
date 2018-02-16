package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class ComputerMovementsTestSuite {
    // Given
    private ComputerMovements computerMovements;
    private int minValueExpected = 1;
    private int endOfStepsNumber = 300;

    @Before
    public void before() {
        computerMovements = new ComputerMovements();
    }

    @Test
    public void testGetComputerChoiceAsInteger() {
        // Given
        int zero = 0;
        // When
        int result = computerMovements.getComputerChoiceAsInteger();
        // Then
        System.out.println(zero + " <--> " + result);
        Assert.assertEquals(zero, result);
    }

    @Test
    public void testGetComputerChoiceAsString() {
        // Given
        String text = "text";
        // When
        String result = computerMovements.getComputerChoiceAsString();
        // Then
        System.out.println(text + " <--> " + result);
        Assert.assertEquals(text, result);
    }

    @Test
    public void test01TrueForComputerGameChoice() {
        // Given
        boolean trueValue = true;
        int maxValueExpected = 5;
        // When
        int maxValue = IntStream.range(0, endOfStepsNumber).map(s -> computerMovements.computerGameChoice(trueValue)).max().getAsInt();
        int minValue = IntStream.range(0, endOfStepsNumber).map(s -> computerMovements.computerGameChoice(trueValue)).min().getAsInt();
        // Then
        System.out.println(maxValueExpected + " <--> " + maxValue);
        Assert.assertEquals(maxValueExpected, maxValue);
        System.out.println(minValueExpected + " <--> " + minValue);
        Assert.assertEquals(minValueExpected, minValue);
    }

    @Test
    public void test02FalseForComputerGameChoice() {
        // Given
        ComputerMovements computerMovements = new ComputerMovements();
        boolean falseValue = false;
        int maxValueExpected = 3;
        // When
        int maxValue = IntStream.range(0, endOfStepsNumber).map(s -> computerMovements.computerGameChoice(falseValue)).max().getAsInt();
        int minValue = IntStream.range(0, endOfStepsNumber).map(s -> computerMovements.computerGameChoice(falseValue)).min().getAsInt();
        // Then
        System.out.println(maxValueExpected + " <--> " + maxValue);
        Assert.assertEquals(maxValueExpected, maxValue);
        System.out.println(minValueExpected + " <--> " + minValue);
        Assert.assertEquals(minValueExpected, minValue);
    }
}