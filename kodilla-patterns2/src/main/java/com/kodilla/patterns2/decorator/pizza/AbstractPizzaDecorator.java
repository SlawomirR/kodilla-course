package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractPizzaDecorator implements Pizza {
    private final Pizza pizza;

    AbstractPizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public BigDecimal getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String getInformation() {
        return pizza.getInformation();
    }
}
