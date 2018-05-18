package com.kodilla.rps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementsOfHumanTestSuite {

    @Test
    public void getMovementName() {
        // Given
        String miki = "Miki";
        MovementsOfHuman moh = new MovementsOfHuman(miki);
        // When
        String rock = moh.getMovementName('1');
        // Then
        assertEquals("ROCK", rock);
    }

    @Test
    public void getPlayerName() {
        // Given
        String miki = "Miki";
        MovementsOfHuman moh = new MovementsOfHuman(miki);
        // When
        String mikiName = moh.getPlayerName();
        // Then
        assertEquals(miki, mikiName);
    }

    @Test
    public void setPlayerName() {
        // Given
        String miki = "Miki";
        MovementsOfHuman moh = new MovementsOfHuman(miki);
        // When
        String mikiName = moh.getPlayerName();
        // Then
        assertEquals(miki, mikiName);
    }
}