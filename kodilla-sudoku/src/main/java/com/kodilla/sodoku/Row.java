package com.kodilla.sodoku;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter(AccessLevel.PACKAGE)
final class Row {
    private List<Element> elementList;

    Row() {
        elementList = new ArrayList<>(Processor.SUDOKU_SIZE);
        for (int i = 0; i < Processor.SUDOKU_SIZE; i++) {
            elementList.add(new Element());
        }
    }
}
