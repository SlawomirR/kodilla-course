package com.kodilla.rps;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameMenuTestSuite {

    @Test
    public void getGameMenu() {
        // Given
        GameMenu gameMenuV3 = new GameMenu(3);
        GameMenu gameMenuV5 = new GameMenu(5);
        // When
        String menuV3 = gameMenuV3.getGameMenu();
        String menuV5 = gameMenuV5.getGameMenu();
        // Then
        assertTrue(menuV3.length() < menuV5.length());
        assertFalse(menuV3.contains("Lizard"));
        assertTrue(menuV5.contains("Lizard"));
    }
}
