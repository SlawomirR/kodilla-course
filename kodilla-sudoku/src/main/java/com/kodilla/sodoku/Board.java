package com.kodilla.sodoku;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter(AccessLevel.PACKAGE)
final class Board extends Prototype {
    private List<Row> rowList;

    Board() {
        rowList = new ArrayList<>(Processor.SUDOKU_SIZE);
        for (int i = 0; i < Processor.SUDOKU_SIZE; i++) {
            rowList.add(new Row());
        }
    }

    Element getElement(int row, int column) {
        return getRowList().get(row).getElementList().get(column);
    }

    Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board)super.clone();
        clonedBoard.rowList = new ArrayList<>(Processor.SUDOKU_SIZE);
        for (Row sRow: rowList) {
            Row clonedElemList = new Row();
            clonedElemList.getElementList().clear();
            for (Element sElem: sRow.getElementList()) {
                Element element = new Element();
                element.setValue(sElem.getValue());
                element.getAvailableGuessValues().clear();
                for (Integer guessValue: sElem.getAvailableGuessValues()) {
                    element.getAvailableGuessValues().add(guessValue);
                }
                clonedElemList.getElementList().add(element);
            }
            clonedBoard.getRowList().add(clonedElemList);
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
        for (int i = 0; i < Processor.SUDOKU_SIZE; i++) {
            printBoardSchema.append(" ").append(i + 1);
        }
        printBoardSchema.append(System.lineSeparator());
        printBoardSchema.append(boardSchemaTopDoubleLine);
        printBoardSchema.append(System.lineSeparator());
        for (int i = 0; i < Processor.SUDOKU_SIZE; i++) {
            for (int j = 0; j < Processor.SUDOKU_SIZE; j++) {
                printBoardSchema.append(0 == (j + 3) % 3 ? "\u2551" : "\u2502").append(rowList.get(i).getElementList().get(j));
            }
            printBoardSchema.append("\u2551").append(i + 1).append(System.lineSeparator());
            printBoardSchema.append(i == 2 || i ==5 ? boardSchemaMiddleDoubleLine : i == 8 ? boardSchemaBottomDoubleLine : boardSchemaMiddleThinLine);
            printBoardSchema.append(System.lineSeparator());
        }
        return printBoardSchema.toString();
    }
}
