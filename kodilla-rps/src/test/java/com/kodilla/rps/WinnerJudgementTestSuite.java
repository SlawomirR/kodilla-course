package com.kodilla.rps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WinnerJudgementTestSuite {

    @Test
    public void determineWinner() {
        // Given
        WinnerJudgement wj = new WinnerJudgement();
        // When
        int one = wj.determineWinner('1', '2');
        // Then
        assertEquals(1, one);
    }
}