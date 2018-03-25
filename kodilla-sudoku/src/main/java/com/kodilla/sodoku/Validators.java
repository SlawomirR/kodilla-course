package com.kodilla.sodoku;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

final class Validators {
    private final Board board;
    private Board tempBoard = null;

    Validators(Board board) {
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

    void validatePointsAndPutToBoard(ArrayDeque<List<Integer>> userPointsToCheckBeforePutToBoardQueue, Processor processor) {
        if (userPointsToCheckBeforePutToBoardQueue.size() > 0) {

            try {
                tempBoard = board.deepCopy();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            for (List<Integer> point : userPointsToCheckBeforePutToBoardQueue) {
                if ( ! isValueAllowedToPut(point.get(0), point.get(1), point.get(2))) {
                    userPointsToCheckBeforePutToBoardQueue.clear();
                    System.out.println("WARNING: Wrong point! Reenter with caution!:");
                    processor.runTheGame();
                } else {
                    tempBoard.getElement(point.get(0), point.get(1)).setValue(point.get(2));
                }
            }
            while ( ! userPointsToCheckBeforePutToBoardQueue.isEmpty()) {
                List<Integer> point = userPointsToCheckBeforePutToBoardQueue.poll();
                processor.putPointToBoard(point.get(0), point.get(1), point.get(2));
            }
        }
    }

    boolean isValueAppearedAsPossibleForGuessing(int row, int column, int proposedValue) {
        return isValueAppearedAsPossibleForGuessingInSector(row, column, proposedValue)
                || isValueAppearedAsPossibleForGuessingInLines(row, column, proposedValue);
    }

    boolean isValueAllowedToPut(int row, int column, int proposedValue) {
        return isValueAllowedForLines(row, column, proposedValue)
                && isValueAllowedForSector(row, column, proposedValue);
    }

    private boolean isValueAppearedAsPossibleForGuessingInSector(int row, int col, int proposedValue) {
        int colSector = col / Processor.BOARD_SECTOR_SIZE;
        int rowSector = row / Processor.BOARD_SECTOR_SIZE;
        for (int r = rowSector * Processor.BOARD_SECTOR_SIZE; r < (rowSector + 1) * Processor.BOARD_SECTOR_SIZE; r++) {
            for (int c = colSector * Processor.BOARD_SECTOR_SIZE; c < (colSector + 1) * Processor.BOARD_SECTOR_SIZE; c++) {
                Processor.solverIterationCounter++;
                if (0 == board.getRowList().get(r).getElementList().get(c).getAvailableGuessValues().size()) {
                    if (proposedValue == board.getRowList().get(r).getElementList().get(c).getValue()) {
                        return true;
                    }
                } else {
                    if (board.getRowList().get(r).getElementList().get(c).getAvailableGuessValues().contains(proposedValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValueAppearedAsPossibleForGuessingInLines(int row, int column, int proposedValue) throws IllegalArgumentException {
        for (int i = 0; i < Processor.SUDOKU_SIZE; i++) {
            Processor.solverIterationCounter++;
            if (board.getRowList().get(row).getElementList().get(i).getAvailableGuessValues().contains(proposedValue)) {
                return true;
            }
            if (board.getRowList().get(i).getElementList().get(column).getAvailableGuessValues().contains(proposedValue)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueAllowedForSector(int row, int col, int proposedValue) throws IllegalArgumentException {
        int colSector = col / Processor.BOARD_SECTOR_SIZE;
        int rowSector = row / Processor.BOARD_SECTOR_SIZE;
        for (int r = rowSector * Processor.BOARD_SECTOR_SIZE; r < (rowSector + 1) * Processor.BOARD_SECTOR_SIZE; r++) {
            for (int c = colSector * Processor.BOARD_SECTOR_SIZE; c < (colSector + 1) * Processor.BOARD_SECTOR_SIZE; c++) {
                Processor.solverIterationCounter++;
                if (proposedValue == board.getRowList().get(r).getElementList().get(c).getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValueAllowedForLines(int row, int column, int proposedValue) {
        for (int i = 0; i < Processor.SUDOKU_SIZE; i++) {
            Processor.solverIterationCounter++;
            if (proposedValue == board.getRowList().get(row).getElementList().get(i).getValue()) {
                return false;
            }
            if (proposedValue == board.getRowList().get(i).getElementList().get(column).getValue()) {
                return false;
            }
        }
        return true;
    }
}
