package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomsDecorator extends AbstractPizzaDecorator {
    private final BigDecimal mushroomsPrice = new BigDecimal(2);
    private final String mushroomsInfo = ", mushrooms";

    MushroomsDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(mushroomsPrice);
    }

    @Override
    public String getInformation() {
        return super.getInformation() + mushroomsInfo;
    }
}
