package com.kodilla.sodoku;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
final class ForGuesses {
    int col;
    int row;
    int possibleValue;

    ForGuesses(int row, int col, int possibleValue) {
        this.col = col;
        this.row = row;
        this.possibleValue = possibleValue;
    }
}
