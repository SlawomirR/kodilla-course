package com.kodilla.good.patterns.searchingFlights;

import java.util.HashMap;
import java.util.Map;

public enum FlightCoreDatabaseEnum {
    WARSZAWA_OKECIE("WaO", "Warszawa", "Okęcie", 0),
    KRAKOW_BALICE("Kra", "Kraków", "Balice", 1),
    GDANSK_REBIECHOWO("Gda", "Gdańsk", "Rębiechowo", 2),
    KATOWICE_PYRZOWICE("Kat", "Katowice", "Pyrzowice", 3),
    WARSZAWA_MODLIN("WaM", "Warszawa", "Modlin", 4),
    WROCLAW_STRACHOWICE("Wro", "Wrocław", "Strachowice", 5),
    POZNAN_LAWICA("Poz", "Poznań", "Ławica", 6),
    RZESZOW_JASIONKA("Rze", "Rzeszów", "Jasionka", 7),
    SZCZECIN_GOLENIOW("Szc", "Szczecin", "Goleniów", 8),
    LUBLIN_SWIDNIK("Lub", "Lublin", "Świdnik", 9),
    BYDGOSZCZ_SZWEDEROWO("Byd", "Bydgoszcz", "Szwederowo", 10),
    LODZ_LUBLINEK("Lod", "Łódź", "Lublinek", 11),
    OLSZTYN_SZYMANY("Ols", "Olsztyn", "Szymany", 12),
    RADOM_SADKOW("Rad", "Radom", "Sadków", 13),
    ZIELONA_GORA_BABIMOST("Zie", "Zielona Góra", "Babimost", 14);

    private String airportShortcutName;
    private String cityName;
    private String airportRegionName;
    private int arrayIndexNumber;

    private static class EnumToMapLoader {
        static Map<String, FlightCoreDatabaseEnum> airportShortcutNameMapWithEnums = new HashMap<>();
    }

    private static class IndexToMapLoader {
        static Map<Integer, FlightCoreDatabaseEnum> arrayIndexNumberMapWithEnums = new HashMap<>();
    }

    FlightCoreDatabaseEnum(String airportShortcutName, String cityName, String airportRegionName, int arrayIndexNumber) {
        this.airportShortcutName = airportShortcutName;
        this.cityName = cityName;
        this.airportRegionName = airportRegionName;
        this.arrayIndexNumber = arrayIndexNumber;
        EnumToMapLoader.airportShortcutNameMapWithEnums.put(airportShortcutName, this);
        IndexToMapLoader.arrayIndexNumberMapWithEnums.put(arrayIndexNumber, this);
    }

    public static FlightCoreDatabaseEnum findEnumsNameWithGivenAirportShortcutName(String airportShortcutName) {
        FlightCoreDatabaseEnum flightCoreDatabaseEnumSingleValue = EnumToMapLoader.airportShortcutNameMapWithEnums.get(airportShortcutName);
        if (flightCoreDatabaseEnumSingleValue == null) {
            throw new IllegalStateException("Choose three-letter shortcut from this list: " + FlightCoreDatabaseEnum.values().toString());
        }
        return flightCoreDatabaseEnumSingleValue;
    }

    public static String findHyphenatedCityRegionNameWithGivenIndex(int arrayIndexNumber) {
        FlightCoreDatabaseEnum flightCoreDatabaseEnumSingleValue = IndexToMapLoader.arrayIndexNumberMapWithEnums.get(arrayIndexNumber);
        if (flightCoreDatabaseEnumSingleValue == null) {
            throw new IllegalStateException(String.format("Array out of bounds exception type: \"%s\".", arrayIndexNumber));
        }
        return flightCoreDatabaseEnumSingleValue.getCityName() + "-" + flightCoreDatabaseEnumSingleValue.getAirportRegionName();
    }

    public String getAirportShortcutName() {
        return airportShortcutName;
    }
    public String getCityName() {
        return cityName;
    }
    public String getAirportRegionName() {
        return airportRegionName;
    }
    public int getArrayIndexNumber() {
        return arrayIndexNumber;
    }

    @Override
    public String toString() {
        return getCityName() + "-" + getAirportRegionName();
    }
}
