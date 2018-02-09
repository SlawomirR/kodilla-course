package com.kodilla.good.patterns.searchingFlights;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SearchFlight {

    List<String> FindingAllFlightsFromTheGivenCity(String flightsFromCity) {
        int arrayIndexNumber = FlightCoreDatabaseEnum.findEnumsNameWithGivenAirportShortcutName(flightsFromCity).getArrayIndexNumber();
        boolean[] chosenDataArrayRaw = FlightsCoreDatabase.flightDatabase[arrayIndexNumber];

        return IntStream.range(0, chosenDataArrayRaw.length)
                .filter(i -> chosenDataArrayRaw[i])
                .mapToObj(FlightCoreDatabaseEnum::findHyphenatedCityRegionNameWithGivenIndex)
                .collect(Collectors.toList());
    }

    List<String> FindingAllFlightsToTheGivenCity(String flightsToCity) {
        int enumSize = FlightCoreDatabaseEnum.values().length;
        int arrayIndexNumber = FlightCoreDatabaseEnum.findEnumsNameWithGivenAirportShortcutName(flightsToCity).getArrayIndexNumber();

        return IntStream.range(0, enumSize)
                .filter(i -> FlightsCoreDatabase.flightDatabase[i][arrayIndexNumber])
                .mapToObj(FlightCoreDatabaseEnum::findHyphenatedCityRegionNameWithGivenIndex)
                .collect(Collectors.toList());
    }

    List<String> findingFlightWithChange(String flightsFromCity, String changeInCity, String flightsToCity) {
        return FindingAllFlightsFromTheGivenCity(flightsFromCity).stream()
                .filter(FindingAllFlightsToTheGivenCity(flightsToCity)::contains)
                .collect(Collectors.toList());
    }

    void showAllShortcutsWithCityNames() {
        Arrays.stream(FlightCoreDatabaseEnum.values())
                .forEach(e -> System.out.println(e.getAirportShortcutName() + " - " + e));
    }
}
