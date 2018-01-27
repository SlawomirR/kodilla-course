package com.kodilla.stream.world;

import java.util.List;

public final class Continent {
    private final String continentName;
    private final List<Country> listOfCountries;

    Continent(final String continent, final List<Country> countries) {
        this.continentName = continent;
        this.listOfCountries = countries;
    }

    List<Country> getListOfCountries() {
        return listOfCountries;
    }
}
