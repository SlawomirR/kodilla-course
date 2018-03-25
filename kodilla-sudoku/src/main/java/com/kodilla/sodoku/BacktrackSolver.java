package com.kodilla.sodoku;

import java.util.ArrayDeque;
import java.util.Deque;

class BacktrackSolver {
    private Board board;
    private Solutions solutions;

    BacktrackSolver(Board board, Solutions solutions) {
        this.solutions = solutions;
        this.board = board;
    }

    void sudokuBacktrackSolver()  {
        addOneMoreLevelGuessing(board);
    }

    private void addOneMoreLevelGuessing(Board currBoard) {
        ForGuesses guessL1;
        Board tempLevelOneBoard = null;
        Deque<ForGuesses> forGuesses = generateGuessingQueue(currBoard);
        while ( ! forGuesses.isEmpty()) {
            try {
                tempLevelOneBoard = currBoard.deepCopy();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            guessL1 = forGuesses.poll();
            Validators validate = new Validators(tempLevelOneBoard);
            if (validate.isValueAllowedToPut(guessL1.row, guessL1.col, guessL1.possibleValue)) {
                tempLevelOneBoard.getElement(guessL1.row, guessL1.col).setValue(guessL1.possibleValue);
            }
            tryToFindSolution(tempLevelOneBoard);
        }
    }

    private void tryToFindSolution(Board tempLevelOneBoard) {
        ForGuesses guessL2;
        Board tempLevelTwoBoard = null;
        Deque<ForGuesses> forGuessInner = generateGuessingQueue(tempLevelOneBoard);
        while ( ! forGuessInner.isEmpty()) {
            try {
                tempLevelTwoBoard = tempLevelOneBoard.deepCopy();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            guessL2 = forGuessInner.poll();
            Validators validate = new Validators(tempLevelTwoBoard);
            if (validate.isValueAllowedToPut(guessL2.row, guessL2.col, guessL2.possibleValue)) {
                tempLevelOneBoard.getElement(guessL2.row, guessL2.col).setValue(guessL2.possibleValue);
            }
            Processor.solverIterationCounter++;
            try {
                SimpleSolver simpleSolver = new SimpleSolver(solutions);
                simpleSolver.sudokuSimpleSolver(tempLevelTwoBoard);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private Deque<ForGuesses> generateGuessingQueue(Board currBoard) {
        Deque<ForGuesses> tempQueue = new ArrayDeque<>();
        for (int r = 0; r < Processor.SUDOKU_SIZE; r++) {
            for (int c = 0; c < Processor.SUDOKU_SIZE; c++) {
                if (currBoard.getElement(r, c).getValue() < 1) {
                    for (Integer value: currBoard.getElement(r, c).getAvailableGuessValues()) {
                        Processor.solverIterationCounter++;
                        tempQueue.offer(new ForGuesses(r, c, value));
                    }
                }
            }
        }
        return new ArrayDeque<>(tempQueue);
    }
}
