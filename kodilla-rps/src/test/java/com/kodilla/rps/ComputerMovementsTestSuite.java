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
        ComputerMovements computerMovements = new ComputerMovements();
        // When
        computerMovements.computerGameChoice(true);
        String result = computerMovements.getComputerChoiceAsString();
        // Then
        Assert.assertTrue(result.length() > 0);
    }

    @Test
    public void test01TrueForComputerGameChoice() {
        // Given
        int maxValueExpected = 5;
        // When
        int maxValue = IntStream.range(0, endOfStepsNumber).map(s -> computerMovements.computerGameChoice(true)).max().getAsInt();
        int minValue = IntStream.range(0, endOfStepsNumber).map(s -> computerMovements.computerGameChoice(true)).min().getAsInt();
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
        int maxValueExpected = 3;
        // When
        int maxValue = IntStream.range(0, endOfStepsNumber).map(s -> computerMovements.computerGameChoice(false)).max().getAsInt();
        int minValue = IntStream.range(0, endOfStepsNumber).map(s -> computerMovements.computerGameChoice(false)).min().getAsInt();
        // Then
        System.out.println(maxValueExpected + " <--> " + maxValue);
        Assert.assertEquals(maxValueExpected, maxValue);
        System.out.println(minValueExpected + " <--> " + minValue);
        Assert.assertEquals(minValueExpected, minValue);
    }
}