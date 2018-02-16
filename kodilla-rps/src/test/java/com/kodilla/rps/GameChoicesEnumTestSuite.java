package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Test;

public class GameChoicesEnumTestSuite {

    @Test
    public void test01convertCharToStringName() {
        // Given
        String expectedText = "Rock";
        char char1 = '1';
        // When
        String result = GameChoicesEnum.convertCharToStringName(char1);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test02convertCharToStringName() {
        // Given
        String expectedText = "Paper";
        char char2 = '2';
        // When
        String result = GameChoicesEnum.convertCharToStringName(char2);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test03convertCharToStringName() {
        // Given
        String expectedText = "Scissors";
        char char3 = '3';
        // When
        String result = GameChoicesEnum.convertCharToStringName(char3);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test04convertCharToStringName() {
        // Given
        String expectedText = "Lizard";
        char char4 = '4';
        // When
        String result = GameChoicesEnum.convertCharToStringName(char4);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test05convertCharToStringName() {
        // Given
        String expectedText = "Spock";
        char char5 = '5';
        // When
        String result = GameChoicesEnum.convertCharToStringName(char5);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test06convertCharToStringName() {
        // Given
        String expectedText = "New Game";
        char charN = 'n';
        // When
        String result = GameChoicesEnum.convertCharToStringName(charN);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test07convertCharToStringName() {
        // Given
        String expectedText = "Exit";
        char charX = 'x';
        // When
        String result = GameChoicesEnum.convertCharToStringName(charX);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test08convertCharToStringName() {
        // Given
        String expectedText = "3 Pieces Game Variety";
        char charS = 's';
        // When
        String result = GameChoicesEnum.convertCharToStringName(charS);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test09convertCharToStringName() {
        // Given
        String expectedText = "5 Pieces Game Variety";
        char charE = 'e';
        // When
        String result = GameChoicesEnum.convertCharToStringName(charE);
        // Then
        System.out.println(expectedText + " <--> " + result);
        Assert.assertEquals(expectedText, result);
    }

    @Test
    public void test10convertCharToStringName() {
        // Given
        String expectedText = "WARNING";
        char charJ = 'j';
        // When
        String result = GameChoicesEnum.convertCharToStringName(charJ);
        // Then
        System.out.println(expectedText + " <--> " + result.substring(0, 7));
        Assert.assertEquals(expectedText, result.substring(0, 7));
    }

    @Test
    public void testQuantityOfEnumEntries() {
        // Given
        int expectedQuantity = 9;
        // When
        int result = GameChoicesEnum.values().length;
        // Then
        Assert.assertEquals(expectedQuantity, result);
    }
}