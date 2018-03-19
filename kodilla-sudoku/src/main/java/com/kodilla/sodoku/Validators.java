package com.kodilla.sodoku;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Validators {
    private SudokuBoard board;

    void setBoard(SudokuBoard board) {
        this.board = board;
    }

    ArrayDeque<List<Integer>> validateUserEnteredData(char pointOrRow, String userInput, int min, long max, int expectedMinDataSize) {
        ArrayDeque<List<Integer>> temporaryQueue = new ArrayDeque<>();
        if (userInput.length() < expectedMinDataSize) {
            System.out.println("WARNING: Not enough numbers.");
            return temporaryQueue;
        }
        for (String value : Arrays.asList(userInput.substring(1).split(","))) {
            if (value.length() != expectedMinDataSize) {
                System.out.println("WARNING: Calculate proper number of digits.");
                return temporaryQueue;
            }
            try {
                if (Long.valueOf(value, 10) < min || Long.valueOf(value, 10) > max) {
                    System.out.println("WARNING: The first value must be greater than 0.");
                    return temporaryQueue;
                }
            } catch (Exception e) {
                System.out.println("WARNING: Illegal character instead of digits.");
                return temporaryQueue;
            }
            if (pointOrRow == 'R') {
                int row = Character.getNumericValue(value.charAt(0));
                for (int i = 1; i < value.length(); i++) {
                    int proposedValue = Character.getNumericValue(value.charAt(i));
                    if (proposedValue > 0) {
                        temporaryQueue.offer(Arrays.asList(row - 1, i - 1, proposedValue));
                    }
                }
            } else {
                int proposedValue = Character.getNumericValue(value.charAt(2));
                if (proposedValue > 0) {
                    temporaryQueue.offer(Arrays.asList(Character.getNumericValue(value.charAt(0)-1), Character.getNumericValue(value.charAt(1)-1), proposedValue));
                }
            }
        }
        return new ArrayDeque<>(temporaryQueue);
    }

    void validatePointsAndPutToBoard(ArrayDeque<List<Integer>> userPointsToCheckBeforePutToBoardQueue, SudokuProcessor processor) {
        if (userPointsToCheckBeforePutToBoardQueue.size() > 0) {
            for (List<Integer> point : userPointsToCheckBeforePutToBoardQueue) {
                if ( ! isValueAllowedToPut(point.get(0), point.get(1), point.get(2))) {
                    userPointsToCheckBeforePutToBoardQueue.clear();
                    processor.runTheGame();
                }
            }
            while ( ! userPointsToCheckBeforePutToBoardQueue.isEmpty()) {
                List<Integer> point = userPointsToCheckBeforePutToBoardQueue.poll();
                processor.putPointToBoard(point.get(0), point.get(1), point.get(2));
            }
        } else {
            userPointsToCheckBeforePutToBoardQueue.clear();
        }
    }

    boolean isValueAppearedAsPossibleForGuessing(int row, int column, int proposedValue) {
        return isValueAppearedAsPossibleForGuessingInSector(row, column, proposedValue)
                && isValueAppearedAsPossibleForGuessingInLines(row, column, proposedValue);
    }

    boolean isValueAllowedToPut(int row, int column, int proposedValue) {
        return isValueAllowedForLines(row, column, proposedValue)
                && isValueAllowedForSector(row, column, proposedValue);
    }

    private boolean isValueAppearedAsPossibleForGuessingInSector(int row, int column, int proposedValue) {
        int columnSector = column / SudokuGame.BOARD_SECTOR_SIZE;
        int rowSector = row / SudokuGame.BOARD_SECTOR_SIZE;
        for (int r = rowSector * SudokuGame.BOARD_SECTOR_SIZE; r < (rowSector + 1) * SudokuGame.BOARD_SECTOR_SIZE; r++) {
            for (int c = columnSector * SudokuGame.BOARD_SECTOR_SIZE; c < (columnSector + 1) * SudokuGame.BOARD_SECTOR_SIZE; c++) {
                SudokuSimpleSolver.SOLVER_ITERATION_COUNTER++;
                return board.getSudokuRowList().get(r).getSudokuElementList().get(c).getAvailableGuessValues().contains(proposedValue);
            }
        }
        return true;
    }

    private boolean isValueAppearedAsPossibleForGuessingInLines(int row, int column, int proposedValue) throws IllegalArgumentException {
        for (int i = 0; i < SudokuGame.SUDOKU_SIZE; i++) {
            SudokuSimpleSolver.SOLVER_ITERATION_COUNTER++;
            return board.getSudokuRowList().get(row).getSudokuElementList().get(i).getAvailableGuessValues().contains(proposedValue)
                    && board.getSudokuRowList().get(i).getSudokuElementList().get(column).getAvailableGuessValues().contains(proposedValue);
        }
        return true;
    }

    private boolean isValueAllowedForSector(int row, int column, int proposedValue) throws IllegalArgumentException {
        int columnSector = column / SudokuGame.BOARD_SECTOR_SIZE;
        int rowSector = row / SudokuGame.BOARD_SECTOR_SIZE;
        for (int r = rowSector * SudokuGame.BOARD_SECTOR_SIZE; r < (rowSector + 1) * SudokuGame.BOARD_SECTOR_SIZE; r++) {
            for (int c = columnSector * SudokuGame.BOARD_SECTOR_SIZE; c < (columnSector + 1) * SudokuGame.BOARD_SECTOR_SIZE; c++) {
                SudokuSimpleSolver.SOLVER_ITERATION_COUNTER++;
                int existedValue = board.getSudokuRowList().get(r).getSudokuElementList().get(c).getValue();
                if (existedValue == proposedValue) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValueAllowedForLines(int row, int column, int proposedValue) {
        for (int i = 0; i < SudokuGame.SUDOKU_SIZE; i++) {
            SudokuSimpleSolver.SOLVER_ITERATION_COUNTER++;
            if (proposedValue == board.getSudokuRowList().get(row).getSudokuElementList().get(i).getValue()) {
                return false;
            }
            if (proposedValue == board.getSudokuRowList().get(i).getSudokuElementList().get(column).getValue()) {
                return false;
            }
        }
        return true;
    }
}
