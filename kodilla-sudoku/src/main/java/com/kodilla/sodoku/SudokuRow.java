package com.kodilla.sodoku;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
final class SudokuRow {
    private List<SudokuElement> sudokuElementList;

    SudokuRow() {
        sudokuElementList = new ArrayList<>(SudokuGame.SUDOKU_SIZE);
        for (int i = 0; i < SudokuGame.SUDOKU_SIZE; i++) {
            sudokuElementList.add(new SudokuElement());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuRow)) return false;
        SudokuRow sudokuRow = (SudokuRow) o;
        return Objects.equals(sudokuElementList, sudokuRow.sudokuElementList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sudokuElementList);
    }

    @Override
    public String toString() {
        return "SudokuRow{" +
                "sudokuElementList=" + sudokuElementList.toString() +
                '}';
    }
}
