package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class GarlicSauceDecorator extends AbstractPizzaDecorator {
    private final BigDecimal garlicSaucePrice = new BigDecimal(2);
    private final String garlicSauceInfo = ", garlic sauce";

    GarlicSauceDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(garlicSaucePrice);
    }

    @Override
    public String getInformation() {
        return super.getInformation() + garlicSauceInfo;
    }
}
