package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage()  {
        int[] numbersArrayOf20 = new int[20];
        IntStream.range(0, 20).forEach(n -> numbersArrayOf20[n]=(n+1));

        ArrayOperations.getAverage(numbersArrayOf20);
        Assert.assertEquals(10.5, ArrayOperations.getAverage(numbersArrayOf20), 0);
    }
}
