package com.kodilla.good.patterns.searchingFlights;

public class FlightsCoreDatabase {
    // the data in rows contains information about flights from cities that are possible
    // the data in columns contains information about flights to which cities are possible
    static final boolean[][] flightDatabase = {
        {false, false, false, true, false, false, true, false, false, true, false, false, true, true, false},
        {false, false, false, false, true, false, false, true, false, false, true, false, false, true, true},
        {true, false, false, false, false, true, false, false, true, false, false, true, false, false, true},
        {true, true, false, false, true, false, true, false, false, true, false, false, true, false, false},
        {false, true, true, false, false, false, false, true, true, false, true, false, false, true, false},
        {false, false, true, true, false, false, false, false, true, false, false, true, false, false, true},
        {true, false, false, true, true, false, false, false, false, true, false, false, true, false, false},
        {false, true, false, false, true, true, false, false, false, false, true, false, false, true, false},
        {false, false, true, false, false, true, true, false, false, false, false, true, false, false, true},
        {true, false, false, true, false, false, true, true, false, false, false, false, true, false, false},
        {false, true, false, false, true, false, false, true, true, false, false, false, false, true, false},
        {false, false, true, false, false, true, false, false, true, true, false, false, false, false, true},
        {true, false, false, true, false, false, true, false, false, true, true, false, false, false, false},
        {false, true, false, false, true, false, false, true, false, false, true, true, false, false, false},
        {false, false, true, false, false, true, false, false, true, false, false, true, true, false, false}
    };
}
