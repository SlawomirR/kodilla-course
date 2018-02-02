package com.kodilla.good.patterns.challenges;

public class User {
    private String firstName;
    private String surname;

    User(final String firstName, final String surmane) {
        this.firstName = firstName;
        this.surname = surmane;
    }

    String getFirstName() {
        return firstName;
    }
    String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "firstName = " + firstName + ", surname = " + surname;
    }
}
