package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .burgers(1)
                .roll("with sezam")
                .sauce(Bigmac.SauceEnum.GARLICKY)
                .ingredients(Bigmac.IngredientsEnum.CHEES)
                .ingredients(Bigmac.IngredientsEnum.CUCUMBER)
                .ingredients(Bigmac.IngredientsEnum.SHRIMPS)
                .build();
        System.out.println(bigmac);
        // When
        int howManyIngredients = bigmac.getIngredients().size();
        // Then
        Assert.assertEquals(3, howManyIngredients);
    }
}
