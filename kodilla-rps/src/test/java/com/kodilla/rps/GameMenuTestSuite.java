package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Test;

public class GameMenuTestSuite {

    @Test
    public void testShowGameMenu() {
        // Given
        boolean trueValue = true;
        boolean falseValue = false;
        // When
        String longerText = GameMenu.showGameMenu(trueValue);
        String shorterText = GameMenu.showGameMenu(falseValue);
        // Then
        Assert.assertTrue(longerText.length() > shorterText.length());
    }

    @Test
    public void testShowGameMenuHeader() {
        Assert.assertTrue(GameMenu.showGameMenuHeader().length() > 0);
    }

    @Test
    public void testShowGameMenuStandardNumbers() {
        Assert.assertTrue(GameMenu.showGameMenuHeader().length() > 0);
    }

    @Test
    public void testShowGameMenu5PiecesVarietyNumbers() {
        Assert.assertTrue(GameMenu.showGameMenuStandardNumbers().length() > 0);
    }

    @Test
    public void testShowGameMenuCharOptions() {
        Assert.assertTrue(GameMenu.showGameMenuCharOptions().length() > 0);
    }

    @Test
    public void testShowGameMenuCharForGameVariety() {
        Assert.assertTrue(GameMenu.showGameMenuCharForGameVariety().length() > 0);
    }
}