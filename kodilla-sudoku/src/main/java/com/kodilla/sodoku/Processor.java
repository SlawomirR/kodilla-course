package com.kodilla.sodoku;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Getter(AccessLevel.PACKAGE)
final class Processor {
    static final int SUDOKU_SIZE = 9;
    static final int BOARD_SECTOR_SIZE = 3;
    private static final String INITIAL_MESSAGE = "____________________________________________________________\n"
            + "SUDOKU Game. Please, fill out the sudoku board with a desired numbers.\n"
            + "For now you can input data as single or multiple rows at once e.g.: R1123456789,2980000321\n"
            + "Important is to write \"R\" at the beginning of a row with data and row number at\n"
            + "the beginning of each data set separated be comas. Zero means empty field.\n"
            + "To control the game use proper words as follows:\n"
            + "- new game: NEW\n"
            + "- end game: EXIT\n"
            + "- resolve game: SOLVE\n"
            + "- play game: PLAY\n"
            + "- to load example game: LOAD\n";
    private final String INFO_ABOUT_ADDING_POINTS = "You can add one or more points e.g.: \"P110,125,141,318\"" + System.lineSeparator()
            + "Every line with point(s) begin with 'P', followed by groups of 3 digits (row, column and value) separated by comma." + System.lineSeparator();
    static long solverIterationCounter = 0;
    private Board board;
    private Validators validate;
    private final Scanner scanner;
    private Solutions solutions;

    Processor() {
        board = new Board();
        validate = new Validators(board);
        scanner = new Scanner(System.in);
        solutions = new Solutions();
    }

    void runTheGame() {
        boolean endTheGame = false;
        String userInput;
        while ( ! endTheGame) {
            System.out.println(INITIAL_MESSAGE);
            System.out.print("Input: ");

            userInput = scanner.next().trim().toUpperCase();
            switch (userInput) {
                case "QUIT":
                case "EXIT":
                    endTheGame = true;
                    scanner.close();
                    break;
                case "SUDOKU":
                case "SOLVE":
                case "RESOLVE":
                case "ANSWER":
                    long startTime = System.currentTimeMillis();
                    solverIterationCounter = 0;
                    SimpleSolver simpleSolver = new SimpleSolver(solutions);
                    simpleSolver.firstCheckSudokuQuality(board);
                    try {
                        simpleSolver.sudokuSimpleSolver(board);
                    } catch (IllegalArgumentException e) {
                        System.out.println("I guess you put wrong Sudoku or take wrong steps in solving so we have trouble!");
                    }
                    long stopTime = System.currentTimeMillis();
                    System.out.println("Solving sudoku by calculating takes: " + (stopTime - startTime) + "ms");

                    if (0 == solutions.getSolutionsCollector().size()) {
                        System.out.println("The entered Sudoku is too difficult for algorithm based on calculations.");
                    }
                    System.out.println("========================> Running guessing mode ...");
                    startTime = System.currentTimeMillis();
                    BacktrackSolver backtrackSolver = new BacktrackSolver(board, solutions);
                    backtrackSolver.sudokuBacktrackSolver();
                    stopTime = System.currentTimeMillis();
                    System.out.println("Solving sudoku by guessing takes additional: " + (stopTime - startTime) + "ms");

                    if (0 == solutions.getSolutionsCollector().size()) {
                        System.out.println("The entered Sudoku is too difficult for algorithm based on simple guessing.");
                    }
                    System.out.println("========================> Running definite mode ...");
                    DefiniteSolvingMethod definiteSolvingMethod = new DefiniteSolvingMethod(board, solutions);
                    definiteSolvingMethod.definiteSolve();
                    if (solutions.getSolutionsCollector().size() > 0) {
                        System.out.println(solutions.getSolutionsCollector().toString());
                        System.out.println("CONGRATULATIONS, The number of SOLUTIONS is: " + solutions.getSolutionsCollector().size());
                    } else {
                        System.out.println("Sudoku is too hard to solve by implemented algorithms ...");
                        System.out.println("... so maybe it's not possible to solve it? Give it up.");
                    }
                    break;
                case "NEW":
                    board = new Board();
                    validate = new Validators(board);
                    solutions = new Solutions();
                    runTheGame();
                case "FULL":
                case "FINISH":
                case "FINISHED":
                case "PLAY":
                case "ALL":
                case "COMPLETE":
                    System.out.println(INFO_ABOUT_ADDING_POINTS);
                    System.out.println(board.toString());
                    break;
                case "LOAD":
                case "EXAMPLE":
                    loadStoredExamples();
                    break;
                default:
                    readEnteredNumbers(userInput);
            }
        }
    }

    private void loadStoredExamples() {
        String userInput;
        String sudokuValue = "";
        Arrays.stream(StoredSudokuExamplesEnum.values()).forEach(System.out::println);
        while (sudokuValue.length() == 0) {
            System.out.print("Write the name of chosen Sudoku from above: ");
            userInput = scanner.next().trim().toUpperCase();
            for (StoredSudokuExamplesEnum name : StoredSudokuExamplesEnum.values()) {
                if (name.name().equals(userInput)) {
                    sudokuValue = name.getSudokuExampleValues();
                }
            }
            if (userInput.equals("EXIT") || userInput.equals("QUIT")) {
                break;
            }
        }
        readEnteredNumbers(sudokuValue);
    }

    private void readEnteredNumbers(String userInput) {
        ArrayDeque<List<Integer>> userPointsToCheckBeforePutToBoardQueue;
        System.out.println("INFO: processing: " + userInput);
//        System.out.print("Enter next data: ");
        userInput = userInput.replaceAll(" ", "").replaceAll("\\.", ",");
        if (userInput.charAt(0) != 'R' && userInput.charAt(0) != 'P') {
            System.out.println("WARNING: Wrong input: expected command word or numbers followed by R or P.");
            return;
        }
        switch(userInput.charAt(0)) {
            case 'R':
                int ROW_MIN_NUMBERS = 10;
                int MIN_VAL_ROW = 1_000_000_000;
                long MAX_VAL_ROW = 10_000_000_000L;
                userPointsToCheckBeforePutToBoardQueue = validate.validateUserEnteredData('R', userInput, MIN_VAL_ROW, MAX_VAL_ROW, ROW_MIN_NUMBERS);
                validate.validatePointsAndPutToBoard(userPointsToCheckBeforePutToBoardQueue, this);
                break;
            case 'P':
                int POINT_MIN_NUMBERS = 3;
                int MIN_VAL_POINT = 110;
                long MAX_VAL_POINT = 1_000L;
                userPointsToCheckBeforePutToBoardQueue = validate.validateUserEnteredData('P', userInput, MIN_VAL_POINT, MAX_VAL_POINT, POINT_MIN_NUMBERS);
                validate.validatePointsAndPutToBoard(userPointsToCheckBeforePutToBoardQueue, this);
                break;
            default:
                System.out.println("WARNING: Wrong input: expected command word or numbers followed by R or P.");
        }
        System.out.println(board.toString());
    }

    void putPointToBoard(int row, int column, int proposedValue) {
        board.getElement(row, column).setValue(proposedValue);
        board.getElement(row, column).getAvailableGuessValues().clear();
    }
}
