package com.kodilla.sodoku;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter
final class SudokuElement {
    private static final int EMPTY = -1;

    private int value;
    private List<Integer> availableGuessValues;

    SudokuElement() {
        value = EMPTY;
        availableGuessValues = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    }

    void setValue(int value) {
        this.value = value == 0 ? -1 : value;
    }

    String printAllElementInfo() {
        return "Value: " + value + " with guessTable: " + availableGuessValues.toString() + ".";
    }


    @Override
    public String toString() {
        if (value == EMPTY || value == 0) {
            return " ";
        }
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuElement)) return false;
        SudokuElement that = (SudokuElement) o;
        return value == that.value &&
                Objects.equals(availableGuessValues, that.availableGuessValues);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, availableGuessValues);
    }
}
