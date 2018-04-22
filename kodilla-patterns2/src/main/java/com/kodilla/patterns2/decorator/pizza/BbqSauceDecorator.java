package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BbqSauceDecorator extends AbstractPizzaDecorator {
    private final BigDecimal bbqSaucePrice = new BigDecimal(2);
    private final String bbqSauceInfo = ", BBQ sauce";

    BbqSauceDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(bbqSaucePrice);
    }

    @Override
    public String getInformation() {
        return super.getInformation() + bbqSauceInfo;
    }
}
