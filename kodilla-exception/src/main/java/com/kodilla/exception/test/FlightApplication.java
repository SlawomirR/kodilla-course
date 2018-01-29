package com.kodilla.exception.test;

public class FlightApplication {

    public static void main(String[] args) {
        Flight flight = new Flight("Warszawa", "Berlin");
        FindFlight findFlight = new FindFlight();

        try {
            findFlight.findFlight(flight);
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("We can seek for different destination.");
        }

    }
}
