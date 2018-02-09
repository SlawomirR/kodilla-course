package com.kodilla.good.patterns.searchingFlights;

public class ApplicationFlight {
    public static void main(String[] args) {
        SearchFlight searchFlight = new SearchFlight();

        System.out.println("\tBelow are all shortcuts with their city names used in search service:");
        searchFlight.showAllShortcutsWithCityNames();
        System.out.println("\tBelow are all flights from the given city (Warszawa-Okęcie)");
        searchFlight.FindingAllFlightsFromTheGivenCity("WaO").stream().forEach(System.out::println);
        System.out.println("\tBelow are all flights to the given city (Warszawa-Modlin)");
        searchFlight.FindingAllFlightsToTheGivenCity("WaM").stream().forEach(System.out::println);
        System.out.println("\tYou can go from Warszawa-Okęcie to Warszawa-Modlin using one of this flight:");
        searchFlight.findingFlightWithChange("WaO", "Szc", "WaM").stream().forEach(System.out::println);;
    }
}
