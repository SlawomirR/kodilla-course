package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;

public final class Country {
    private final String countryName;
    private final BigDecimal peopleQuantity;

    Country(final String countryName, final String stringOfPeopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = new BigDecimal(stringOfPeopleQuantity
                .replaceAll("_", "")
                .replaceAll(" ", "")
                .replaceAll("\t", "")
        );
    }

    String getCountryName() {
        return countryName;
    }

    BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(countryName, country.countryName) &&
                Objects.equals(peopleQuantity, country.peopleQuantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryName, peopleQuantity);
    }

    @Override
    public String toString() {

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        DecimalFormat numberFormat = new DecimalFormat("###,##0.##", symbols);
        return String.format("%-32s, peopleQuantity= %13s", countryName, numberFormat.format(peopleQuantity));
    }

    String printCountryInfo(int longestCountryNameSize) {

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        DecimalFormat numberFormat = new DecimalFormat("###,##0.##", symbols);
        return String.format("%-" + longestCountryNameSize + "s, peopleQuantity= %13s", countryName, numberFormat.format(peopleQuantity));
    }
}
