package com.kodilla.sodoku;

import java.util.ArrayDeque;
import java.util.Deque;

class SudokuBacktrackSolver {
    static int SOLVER_ITERATION_COUNTER = 0;
    private SudokuBoard board;
    private Deque<ForGuesses> forGuesses = new ArrayDeque<>();
    private Solutions solutions;

    SudokuBacktrackSolver(SudokuBoard board, Solutions solutions) {
        this.board = board;
        this.solutions = solutions;
        sudokuBacktrackSolver();
    }

    boolean sudokuBacktrackSolver()  {
        SudokuBoard boardBackup = null;
        try {
            boardBackup = board.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if ( ! board.equals(boardBackup)) {
            System.out.println("ERROR: Object Board is not equal to it's deep copy!");
            return false;
        }
        for (int r = 0; r < SudokuGame.SUDOKU_SIZE; r++) {
            for (int c = 0; c < SudokuGame.SUDOKU_SIZE; c++) {
                if (board.getSudokuElement(r, c).getValue() < 1) {
                    for (Integer value: board.getSudokuElement(r, c).getAvailableGuessValues()) {
                        System.out.println(r+", "+c+": "+value+" ==> queue size: "+forGuesses.size());
                        forGuesses.offer(new ForGuesses(r, c, value));
                    }
                }
            }
        }
        SudokuBoard testBoard = null;
        ForGuesses guess;
        while ( ! forGuesses.isEmpty()) {
            try {
                testBoard = board.deepCopy();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            guess = forGuesses.peek();
                testBoard.getSudokuElement(guess.row, guess.col).setValue(guess.possibleValue);
                try {
                    new SudokuSimpleSolver(testBoard, solutions);
                } catch (IllegalArgumentException e) {
                    System.out.println("Point (" + guess.row +", " + guess.col + ") with value: " + guess.possibleValue + " doesn't give a solution.");
                } finally {
                    forGuesses.poll();
                }
            System.out.println("One completed. " + forGuesses.size() + " possibilities left.");
        }
        return false;
    }
}
