package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OnionDecorator extends AbstractPizzaDecorator {
    private final BigDecimal onionPrice = new BigDecimal(2);
    private final String onionInfo = ", onion";

    OnionDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(onionPrice);
    }

    @Override
    public String getInformation() {
        return super.getInformation() + onionInfo;
    }
}
