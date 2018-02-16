package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class GameUtilsTestSuite {
    private final String newLine = System.getProperty("line.separator");
    private GameUtils gameUtils;

    @Before
    public void before() {
        gameUtils = new GameUtils();
    }

    @Test
    public void testCurrentRoundNumberInitialValue() {
        Assert.assertEquals(1, gameUtils.getCurrentRoundNumber());
    }

    @Test
    public void testScoresArrayInitialValue() {
        Assert.assertEquals(0, gameUtils.getComputerScore());
        Assert.assertEquals(0, gameUtils.getHumanScore());
    }

    @Test
    public void isExitConfirmed() {
        Assert.assertEquals(false, gameUtils.isExitConfirmed());
    }

    @Test
    public void setExitConfirmed() {
        gameUtils.setExitConfirmed();
        Assert.assertEquals(true, gameUtils.isExitConfirmed());
    }

    @Test
    public void resetScoresArrayForNewGame() {
        gameUtils.resetScoresArrayForNewGame();
        Assert.assertEquals(0, gameUtils.getComputerScore());
        Assert.assertEquals(0, gameUtils.getHumanScore());
    }

    @Test
    public void checkIfGameIsEnded() {
        gameUtils.setRoundNumberToWin(0);
        gameUtils.increaseComputerScoreByOne();
        gameUtils.checkIfGameIsEnded();
        Assert.assertTrue(gameUtils.isExitConfirmed());
    }

    @Test
    public void showGameSummary() {
        Assert.assertTrue(gameUtils.showGameSummary("Bear").length() > 0);
    }

    @Test
    public void test01ShowAndCompareMovementsResult() {
        int computerScore = 1;
        int humanScore = 1;
        String result = gameUtils.showAndCompareMovementsResult(computerScore, humanScore, "ADraw");
        Assert.assertTrue(result.length() > 0);
    }

    @Test
    public void test02ShowAndCompareMovementsResult() {
        int computerScore = 4;
        int humanScore = 1;
        int before = gameUtils.getHumanScore();
        gameUtils.showAndCompareMovementsResult(computerScore, humanScore, "Comp_Winner");
        int result = gameUtils.getHumanScore();
        Assert.assertEquals(before+1, result);
    }

    @Test
    public void test03ShowAndCompareMovementsResult() {
        int computerScore = 2;
        int humanScore = 5;
        int before = gameUtils.getComputerScore();
        gameUtils.showAndCompareMovementsResult(computerScore, humanScore, "User_Winner");
        int result = gameUtils.getComputerScore();
        Assert.assertEquals(before+1, result);
    }

    @Test
    public void test01SayGoodbye() {
        Scanner scanner = new Scanner("Alice has a cat.");
        Assert.assertTrue(gameUtils.sayGoodbyeAndCloseScanner(scanner).length() > 0);
    }

    @Test(expected = IllegalStateException.class)
    public void test02SayGoodbyeIsScannerClosed() {
        Scanner scanner = new Scanner("Alice has a cat.");
        gameUtils.sayGoodbyeAndCloseScanner(scanner);
        scanner.next();
    }

    @Test
    public void showApplicationName() {
        Assert.assertTrue(GameUtils.showApplicationName().length() > 0);
    }

    @Test
    public void test01AskRoundNumberToWin() {
        // Given
        String data = "2";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        gameUtils.askRoundNumberToWin(userInputsScanner);
        int expectedInt = 2;
        // Then
        Assert.assertEquals(expectedInt, gameUtils.getRoundNumberToWin());
    }

    @Test
    public void test02AskRoundNumberToWin() {
        // Given
        String data = "-1" + newLine + "2";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        gameUtils.askRoundNumberToWin(userInputsScanner);
        int expectedInt = 2;
        // Then
        Assert.assertEquals(expectedInt, gameUtils.getRoundNumberToWin());
    }

    @Test
    public void test03AskRoundNumberToWin() {
        // Given
        String data = "H" + newLine + "2";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        gameUtils.askRoundNumberToWin(userInputsScanner);
        int expectedInt = 2;
        // Then
        Assert.assertEquals(expectedInt, gameUtils.getRoundNumberToWin());
    }

    @Test(expected = IllegalStateException.class)
    public void sayGoodbye1() {
        Scanner scanner = new Scanner(System.in);
        gameUtils.sayGoodbyeAndCloseScanner(scanner);
        scanner.next();
    }

    @Test
    public void testTakeUserScannerInputAsChar() {
        // Given
        Scanner userInputsScanner = new Scanner("1 can be a number if we tak char at index 0.");
        int One = 1;
        // When
        char result = gameUtils.takeUserScannerInputAsChar(userInputsScanner);
        // Then
        Assert.assertEquals(One, Character.digit(result, 10));
    }

    @Test
    public void acceptedGreaterThanZeroValue() {
        char greaterThanZero = '3';
        char zero = '0';
        char notNumber = 'Z';
        Assert.assertTrue(gameUtils.acceptedGreaterThanZeroValue(greaterThanZero));
        Assert.assertFalse(gameUtils.acceptedGreaterThanZeroValue(zero));
        Assert.assertFalse(gameUtils.acceptedGreaterThanZeroValue(notNumber));
    }
}