package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SalamiDecorator extends AbstractPizzaDecorator {
    private final BigDecimal salamiPrice = new BigDecimal(1);
    private final String salamiInfo = ", salami";

    SalamiDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(salamiPrice);
    }

    @Override
    public String getInformation() {
        return super.getInformation() + salamiInfo;
    }

}
