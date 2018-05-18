package com.kodilla.rps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WinningRuleTest {

    @Test
    public void getWinner() {
        // Given
        WinningRule winningRule = new WinningRule();
        Character c = 'c';
        // When
        Character result = winningRule.getWinner('1', '2');
        // Then
        assertEquals(c, result);
    }
}