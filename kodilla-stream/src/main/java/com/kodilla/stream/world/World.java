package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;

public final class World {
    private final List<Continent> listOfContinents;

    World(final List<Continent> listOfContinents) {
        this.listOfContinents = listOfContinents;
    }

    List<Continent> getListOfContinents() {
        return listOfContinents;
    }

    BigDecimal getPeopleQuantity() {
        return listOfContinents.stream()
                .flatMap(c -> c.getListOfCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
