package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class HumanChoicesAndMovementsTestSuite {
    private final String newLine = System.getProperty("line.separator");
    private HumanChoicesAndMovements humanChoicesAndMovements;

    @Before
    public void before() {
        // Given
        humanChoicesAndMovements = new HumanChoicesAndMovements();
    }

    @Test
    public void testIsGame5PiecesVarietyInitialValue() {
        // Given
        //from @Before
        // When
        //do nothing
        // Then
        Assert.assertTrue( ! humanChoicesAndMovements.isGame5PiecesVariety());
    }

    @Test
    public void testGetHumanChoiceIntegerInitialValue() {
        // Given
        //from @Before
        // When
        int initialValueZero = 0;
        // Then
        Assert.assertEquals(initialValueZero, humanChoicesAndMovements.getHumanChoiceAsInteger());
    }

    @Test
    public void testSetHumanChoiceAsString() {
        // Given
        char humanMovementChoice = '1';
        String expectedTextRock = "Rock";
        // When
        humanChoicesAndMovements.setHumanChoiceAsString(humanMovementChoice);
        String result = humanChoicesAndMovements.getHumanChoiceAsString();
        // Then
        System.out.println(expectedTextRock + " <--> " + result);
        Assert.assertEquals(expectedTextRock, result);
    }

    @Test
    public void testSetHumanChoiceAsInteger() {
        // Given
        char humanMovementChoice = '3';
        int expectedIntegerThree = 3;
        // When
        humanChoicesAndMovements.setHumanChoiceAsInteger(humanMovementChoice);
        int result = humanChoicesAndMovements.getHumanChoiceAsInteger();
        // Then
        System.out.println(expectedIntegerThree + " <--> " + result);
        Assert.assertEquals(expectedIntegerThree, result);
    }

    @Test
    public void test01AskHumanName() {
        // Given
        String data = "Aaron";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        String userName = "Aaron";
        String result = humanChoicesAndMovements.askHumanName(userInputsScanner);
        // Then
        Assert.assertEquals(userName, result);
        userInputsScanner.close();
    }

    @Test
    public void test02AskHumanName() {
        // Given
        String data = "" + newLine + "Misia";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        String userName = "Misia";
        String result = humanChoicesAndMovements.askHumanName(userInputsScanner);
        // Then
        Assert.assertEquals(userName, result);
        userInputsScanner.close();
    }

    @Test
    public void testAcceptOnlyKeyEChar() {
        // Given
        char charE = 'e';
        // When
        humanChoicesAndMovements.acceptOnlyKeyEChar(charE);
        // Then
        Assert.assertTrue(humanChoicesAndMovements.isGame5PiecesVariety());
    }

    @Test
    public void testAskGameVariety() {
        // Given
        String data = "E";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        boolean result = humanChoicesAndMovements.askGameVariety(userInputsScanner);
        // Then
        Assert.assertTrue(result);
        userInputsScanner.close();
    }

    @Test
    public void test01HumanMovement() {
        // Given
        String userName = "Aaron";
        String data = "3";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        String expectedString = "Scissors";
        String result = humanChoicesAndMovements.humanMovement(userInputsScanner, userName);
        // Then
        Assert.assertEquals(expectedString, result);
        userInputsScanner.close();
    }

    @Test
    public void test02HumanMovement() {
        // Given
        String userName = "Aaron";
        String data = "N" + newLine + "y";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        String expectedString = "New Game";
        String result = humanChoicesAndMovements.humanMovement(userInputsScanner, userName);
        // Then
        Assert.assertEquals(expectedString, result);
        userInputsScanner.close();
    }

    @Test
    public void test03HumanMovement() {
        // Given
        //from @Before
        String userName = "Aaron";
        String data = "Default" + newLine + "2";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        String expectedString = "Pape";
        String result = humanChoicesAndMovements.humanMovement(userInputsScanner, userName);
        // Then
        Assert.assertEquals(expectedString, result.substring(0, 4));
        userInputsScanner.close();
    }

    @Test
    public void testGetHumanChoiceInteger() {
        // Given
        String userName = "Aaron";
        String data = "3";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        int expectedInt = 3;
        humanChoicesAndMovements.humanMovement(userInputsScanner, userName);
        int result = humanChoicesAndMovements.getHumanChoiceAsInteger();
        // Then
        Assert.assertEquals(expectedInt, result);
        userInputsScanner.close();
    }

    @Test
    public void testGetHumanChoiceString() {
        // Given
        String userName = "Aaron";
        Scanner userInputsScanner = new Scanner("3");
        // When
        String expectedString = "Scissors";
        humanChoicesAndMovements.humanMovement(userInputsScanner, userName);
        String result = humanChoicesAndMovements.getHumanChoiceAsString();
                // Then
        Assert.assertEquals(expectedString, result);
        userInputsScanner.close();
    }

    @Test
    public void test01ConfirmCancelCurrentGame() {
        // Given
        String userName = "Aaron";
        String data = "bad key" + newLine + "x" + newLine + "y";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        int expectedInt = 0;
        int result = humanChoicesAndMovements.confirmCancelCurrentGame(userInputsScanner, userName);
        // Then
        Assert.assertEquals(expectedInt, result);
        userInputsScanner.close();
    }

    @Test
    public void test02ConfirmCancelCurrentGame() {
        // Given
        String userName = "Aaron";
        String data = "Y";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner userInputsScanner = new Scanner(System.in);
        System.setIn(stdin);
        // When
        int expectedInt = 0;
        int result = humanChoicesAndMovements.confirmCancelCurrentGame(userInputsScanner, userName);
        // Then
        Assert.assertEquals(expectedInt, result);
        userInputsScanner.close();
    }

    @Test
    public void testTakeUserScannerInputAsChar() {
        // Given
        Scanner userInputsScanner = new Scanner("1 can be a number if we tak char at index 0.");
        int One = 1;
        // When
        char result = humanChoicesAndMovements.takeUserScannerInputAsChar(userInputsScanner);
        // Then
        Assert.assertEquals(One, Character.digit(result, 10));
    }
}