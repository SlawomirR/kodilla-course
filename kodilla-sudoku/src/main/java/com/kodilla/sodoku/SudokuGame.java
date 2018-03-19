package com.kodilla.sodoku;

public class SudokuGame {
    static final int SUDOKU_SIZE = 9;
    static final int BOARD_SECTOR_SIZE = 3;
    private static final String INITIAL_MESSAGE = "SUDOKU Game. Please, fill out the sudoku board with a desired numbers.\n"
            + "For now you can input data as single or multiple rows at once e.g.: R1123456789,2980000321\n"
            + "Important is to write \"R\" at the beginning of a row with data and row number at\n"
            + "the beginning of each data set separated be comas. Zero means empty field.\n"
            + "To control the game use proper words as follows:\n"
            + "- new game: NEW\n"
            + "- end game: EXIT\n"
            + "- resolve game: SOLVE\n"
            + "- try again with entered data: RESET\n"
            + "- play game: PLAY\n"
            + "- to load example game: LOAD\n";

    public static void main(String[] args) {
        SudokuProcessor sudokuProcessor = new SudokuProcessor();
        boolean gameFinished = false;

        while ( ! gameFinished) {
            System.out.println(INITIAL_MESSAGE);
            sudokuProcessor.runTheGame();
            gameFinished = true;
        }
    }
}
