package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public final class BasicPizza implements Pizza {
    private final BigDecimal price = new BigDecimal(15);
    private final String information = "Your pizza with tomato sauce, cheese";

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getInformation() {
        return information;
    }
}
