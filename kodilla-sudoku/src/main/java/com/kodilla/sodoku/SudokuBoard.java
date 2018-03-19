package com.kodilla.sodoku;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final class SudokuBoard extends Prototype {
    @Getter
    private List<SudokuRow> sudokuRowList;

    SudokuBoard() {
        sudokuRowList = new ArrayList<>(SudokuGame.SUDOKU_SIZE);
        for (int i = 0; i < SudokuGame.SUDOKU_SIZE; i++) {
            sudokuRowList.add(new SudokuRow());
        }
    }

    SudokuElement getSudokuElement(int row, int column) {
        return getSudokuRowList().get(row).getSudokuElementList().get(column);
    }

    SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard)super.clone();
        clonedBoard.sudokuRowList = new ArrayList<>(SudokuGame.SUDOKU_SIZE);
        for (SudokuRow sRow: sudokuRowList) {
            SudokuRow clonedElemList = new SudokuRow();
            clonedElemList.getSudokuElementList().clear();
            for (SudokuElement sElem: sRow.getSudokuElementList()) {
                SudokuElement element = new SudokuElement();
                element.setValue(sElem.getValue());
                element.getAvailableGuessValues().clear();
                for (Integer guessValue: sElem.getAvailableGuessValues()) {
                    element.getAvailableGuessValues().add(guessValue);
                }
                clonedElemList.getSudokuElementList().add(element);
            }
            clonedBoard.getSudokuRowList().add(clonedElemList);
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        StringBuilder printBoardSchema = new StringBuilder();
        String boardSchemaTopDoubleLine = "\u2554\u2550\u2564\u2550\u2564\u2550\u2566\u2550\u2564\u2550\u2564\u2550\u2566\u2550\u2564\u2550\u2564\u2550\u2557";
        String boardSchemaMiddleThinLine = "\u255f\u2500\u253c\u2500\u253c\u2500\u256b\u2500\u253c\u2500\u253c\u2500\u256b\u2500\u253c\u2500\u253c\u2500\u2562";
        String boardSchemaMiddleDoubleLine = "\u2560\u2550\u256a\u2550\u256a\u2550\u256c\u2550\u256a\u2550\u256a\u2550\u256c\u2550\u256a\u2550\u256a\u2550\u2563";
        String boardSchemaBottomDoubleLine = "\u255a\u2550\u2567\u2550\u2567\u2550\u2569\u2550\u2567\u2550\u2567\u2550\u2569\u2550\u2567\u2550\u2567\u2550\u255d";
        for (int i = 0; i < SudokuGame.SUDOKU_SIZE; i++) {
            printBoardSchema.append(" ").append(i + 1);
        }
        printBoardSchema.append(System.lineSeparator());
        printBoardSchema.append(boardSchemaTopDoubleLine);
        printBoardSchema.append(System.lineSeparator());
        for (int i = 0; i < SudokuGame.SUDOKU_SIZE; i++) {
            for (int j = 0; j < SudokuGame.SUDOKU_SIZE; j++) {
                printBoardSchema.append(0 == (j + 3) % 3 ? "\u2551" : "\u2502").append(sudokuRowList.get(i).getSudokuElementList().get(j));
            }
            printBoardSchema.append("\u2551").append(i + 1).append(System.lineSeparator());
            printBoardSchema.append(i == 2 || i ==5 ? boardSchemaMiddleDoubleLine : i == 8 ? boardSchemaBottomDoubleLine : boardSchemaMiddleThinLine);
            printBoardSchema.append(System.lineSeparator());
        }
        return printBoardSchema.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuBoard)) return false;
        SudokuBoard that = (SudokuBoard) o;
        return Objects.equals(sudokuRowList, that.sudokuRowList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sudokuRowList);
    }
}
