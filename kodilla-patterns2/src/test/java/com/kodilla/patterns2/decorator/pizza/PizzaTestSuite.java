package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaTestSuite {
    @Test
    public void testBasicPizzaGetCost() {
        // Given
        Pizza thePizza = new BasicPizza();
        // When
        BigDecimal calculatedCost = thePizza.getPrice();
        // Then
        Assert.assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaGetInformation() {
        // Given
        Pizza thePizza = new BasicPizza();
        // When
        String description = thePizza.getInformation();
        // Then
        Assert.assertEquals("Your pizza with tomato sauce, cheese", description);
    }

    @Test
    public void testPizzaWithHamGetCost() {
        // Given
        Pizza thePizza = new BasicPizza();
        thePizza = new HamDecorator(thePizza);
        // When
        BigDecimal theCost = thePizza.getPrice();
        // Then
        Assert.assertEquals(new BigDecimal(17), theCost);
    }

    @Test
    public void testPizzaWithHamGetInformation() {
        // Given
        Pizza thePizza = new BasicPizza();
        thePizza = new HamDecorator(thePizza);
        // When
        String description = thePizza.getInformation();
        // Then
        Assert.assertEquals("Your pizza with tomato sauce, cheese, ham", description);
    }

    @Test
    public void testPizzaWithMushroomsAndBbqSauceGetCost() {
        // Given
        Pizza thePizza = new BasicPizza();
        thePizza = new MushroomsDecorator(thePizza);
        thePizza = new BbqSauceDecorator(thePizza);
        // When
        BigDecimal theCost = thePizza.getPrice();
        // Then
        Assert.assertEquals(new BigDecimal(19), theCost);
    }

    @Test
    public void testPizzaWithMushroomsAndBbqSauceGetInformation() {
        // Given
        Pizza thePizza = new BasicPizza();
        thePizza = new MushroomsDecorator(thePizza);
        thePizza = new BbqSauceDecorator(thePizza);
        // When
        String description = thePizza.getInformation();
        // Then
        Assert.assertEquals("Your pizza with tomato sauce, cheese, mushrooms, BBQ sauce", description);
    }

    @Test
    public void testPizzaWithSalamiAndOnionAndGarlicSauceGetCost() {
        // Given
        Pizza thePizza = new BasicPizza();
        thePizza = new SalamiDecorator(thePizza);
        thePizza = new OnionDecorator(thePizza);
        thePizza = new GarlicSauceDecorator(thePizza);
        // When
        BigDecimal theCost = thePizza.getPrice();
        // Then
        Assert.assertEquals(new BigDecimal(20), theCost);
    }

    @Test
    public void testPizzaWithSalamiAndOnionAndGarlicSauceGetInformation() {
        // Given
        Pizza thePizza = new BasicPizza();
        thePizza = new SalamiDecorator(thePizza);
        thePizza = new OnionDecorator(thePizza);
        thePizza = new GarlicSauceDecorator(thePizza);
        // When
        String description = thePizza.getInformation();
        // Then
        Assert.assertEquals("Your pizza with tomato sauce, cheese, salami, onion, garlic sauce", description);
    }

}
