package com.kodilla.testing.forum;

import com.kodilla.testing.calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class CalculatorTestSuite {
    private TestName testName = new TestName();
    private Calculator calculator = new Calculator();

    @Rule
    public TestName getTestName() {
        return testName;
    }
    private int getNumberA() {
        return 6;
    }
    private int getNumberB() {
        return 2;
    }

    @Before
    public void before() throws Exception {
        System.out.println("We are proceeding test method: " + getTestName().getMethodName());
    }

    @Test
    public void testCaseCalculatorAdd() {
        // Given
        //        Calculator calculator = new Calculator();
        // When
        int calcAdd = calculator.add(getNumberA(),getNumberB());
        // Then
        Assert.assertEquals(getNumberA()+getNumberB(), calcAdd);
    }

    @Test
    public void testCaseCalculatorSubtract() {
        // Given
        //        Calculator calculator = new Calculator();
        // When
        int calcSub = calculator.subtract(getNumberA(),getNumberB());
        // Then
        Assert.assertEquals(getNumberA()-getNumberB(), calcSub);
    }
}
