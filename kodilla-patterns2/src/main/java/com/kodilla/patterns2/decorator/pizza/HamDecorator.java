package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamDecorator extends AbstractPizzaDecorator {
    private final BigDecimal hamPrice = new BigDecimal(2);
    private final String hamInfo = ", ham";

    HamDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(hamPrice);
    }

    @Override
    public String getInformation() {
        return super.getInformation() + hamInfo;
    }
}
