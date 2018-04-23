package com.kodilla.patterns2.aop.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Test
    public void testAdd() {
        // Given
        // When
        double result = calculator.add(10, 15);
        // Then
        LOGGER.info("Testing add method");
        Assert.assertEquals(25, result, 0);
    }

    @Test
    public void testSub() {
        //Given
        //When
        double result = calculator.sub(10, 15);
        //Then
        LOGGER.info("Testing sub method");
        Assert.assertEquals(-5, result, 0);
    }

    @Test
    public void testMul() {
        //Given
        //When
        double result = calculator.mul(10, 15);
        //Then
        LOGGER.info("Testing mul method");
        Assert.assertEquals(150, result, 0);
    }

    @Test
    public void testDiv() {
        //Given
        //When
        double result = calculator.div(15, 5);
        //Then
        LOGGER.info("Testing div method");
        Assert.assertEquals(3, result, 0);
    }

    @Test
    public void testFactorial() {
        //Given
        //When
        BigInteger result = calculator.factorial(new BigInteger("1000"));
        //Then
        LOGGER.info("Testing factorial method");
        System.out.println(result);

        Assert.assertTrue(BigInteger.ONE.compareTo(result) < 0);
    }
}
