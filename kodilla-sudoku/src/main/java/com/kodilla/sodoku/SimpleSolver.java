package com.kodilla.sodoku;

import java.util.*;

final class SimpleSolver {
    private Solutions solutions;

    SimpleSolver(Solutions solutions) {
        this.solutions = solutions;
    }

    boolean firstCheckSudokuQuality(Board board) {
        final int uniqueNumbersForOneSolution = 8;
        final int lowestQuantityForOneSolution = 17;
        Set<Integer> uniqueNumbersSet = new HashSet<>();
        long numbersQuantity = board.getRowList().stream()
                .flatMap(sudokuRow -> sudokuRow.getElementList().stream())
                .filter(element -> element.getValue() > 0)
                .peek(element -> uniqueNumbersSet.add(element.getValue()))
                .count();
        if (numbersQuantity < lowestQuantityForOneSolution || uniqueNumbersSet.size() < uniqueNumbersForOneSolution) {
            System.out.println("It is POSSIBLE zero or more than one solution in your Sudoku because " +
                    "you put: " + numbersQuantity + " containing " + uniqueNumbersSet.size() + " unique once.");
            return false;
        } else {
            System.out.println("Sudoku you put has: " + numbersQuantity + " given numbers containing of " + uniqueNumbersSet.size() + " different digits.");
        }
        return true;
    }

    void sudokuSimpleSolver(Board board) throws IllegalArgumentException {
        boolean isSomethingChanged = true;
        Validators validate = new Validators(board);
        Processor.solverIterationCounter++;
        while (isSomethingChanged) {
            isSomethingChanged = false;
            for (int cellRow = 0; cellRow < Processor.SUDOKU_SIZE; cellRow++) {
                for (int cellCol = 0; cellCol < Processor.SUDOKU_SIZE; cellCol++) {
                    if (board.getElement(cellRow, cellCol).getValue() > 0) {
                        continue;
                    }
                    int availableGuessValuesSize = board.getElement(cellRow, cellCol).getAvailableGuessValues().size();
                    for (int i = availableGuessValuesSize - 1; i >= 0; i--) {
                        Processor.solverIterationCounter++;
                        int valueFromAvailableToGuess = board.getElement(cellRow, cellCol).getAvailableGuessValues().get(i);
                        boolean isAllowedToPut = validate.isValueAllowedToPut(cellRow, cellCol, valueFromAvailableToGuess);
                        if (!isAllowedToPut) {
                            board.getElement(cellRow, cellCol).getAvailableGuessValues().remove((Integer) valueFromAvailableToGuess);
                            availableGuessValuesSize = board.getElement(cellRow, cellCol).getAvailableGuessValues().size();
                            isSomethingChanged = true;
                            if (availableGuessValuesSize == 1) {
                                valueFromAvailableToGuess = board.getElement(cellRow, cellCol).getAvailableGuessValues().get(0);
                                isAllowedToPut = validate.isValueAllowedToPut(cellRow, cellCol, valueFromAvailableToGuess);
                                if (isAllowedToPut) {
                                    board.getElement(cellRow, cellCol).setValue(valueFromAvailableToGuess);
                                    board.getElement(cellRow, cellCol).getAvailableGuessValues().clear();
                                    i = 0;
                                    isSomethingChanged = true;
                                } else {
                                    throw new IllegalArgumentException("STATUS - Reconnect to guessing method!!!!!");
                                }
                            }
                        } else {
                            if (!validate.isValueAppearedAsPossibleForGuessing(cellRow, cellCol, valueFromAvailableToGuess)) {
                                board.getElement(cellRow, cellCol).setValue(valueFromAvailableToGuess);
                                board.getElement(cellRow, cellCol).getAvailableGuessValues().clear();
                                i = 0;
                                isSomethingChanged = true;
                            }
                        }
                    }
                }
            }
        }
        boolean isSolved = isSolved(board);
        if (isSolved) {
            try {
                solutions.getSolutionsCollector().add(board.deepCopy());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isSolved(Board board) {
        return board.getRowList().stream()
                .flatMap(sudokuRow -> sudokuRow.getElementList().stream())
                .filter(element -> element.getValue() > 0)
                .count() == 81;
    }
}
