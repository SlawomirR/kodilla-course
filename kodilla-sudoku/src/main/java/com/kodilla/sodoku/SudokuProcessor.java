package com.kodilla.sodoku;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.*;

class SudokuProcessor {
    private final String INFO_ABOUT_ADDING_POINTS = "You can add one or more points e.g.: \"P110,125,141,318\"" + System.lineSeparator()
            + "Every line with point(s) begin with 'P', followed by groups of 3 digits (row, column and value) separated by comma." + System.lineSeparator();
    private SudokuSimpleSolver simpleSolver;
    boolean isSolved;
    @Setter(AccessLevel.PACKAGE)
    private boolean simpleSolverSolution = false;
    private SudokuBoard board;
    private Validators validate;
//    private ArrayDeque<List<Integer>> userPointsToCheckBeforePutToBoardQueue;
    private Scanner scanner;
    private Solutions solutions;

    SudokuProcessor() {
        board = new SudokuBoard();
        validate = new Validators();
        validate.setBoard(board);
//        userPointsToCheckBeforePutToBoardQueue = new ArrayDeque<>();
        scanner = new Scanner(System.in);
        solutions = new Solutions(); // TODO it deletes older info !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    boolean runTheGame() {
        boolean endTheGame = false;
        boolean result = false;
        String userInput;
        while ( ! endTheGame) {
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
                    SudokuSimpleSolver.SOLVER_ITERATION_COUNTER = 0;
                    simpleSolver = new SudokuSimpleSolver(board, solutions);
                    long stopTime = System.currentTimeMillis();
                    System.out.println("Solving sudoku by calculating takes: " + (stopTime - startTime) + "ms");

                    if ( ! simpleSolver.isSolved) {
                        System.out.println("Running guessing mode ...");
//                    SudokuBacktrackSolver.SOLVER_ITERATION_COUNTER = 0;
                        startTime = System.currentTimeMillis();
                        new SudokuBacktrackSolver(board, solutions);
                        stopTime = System.currentTimeMillis();
                        System.out.println("Solving sudoku by guessing takes: " + (stopTime - startTime) + "ms");
                    }
                    if (solutions.getSolutionsCollector().size() > 0) {
                        System.out.println(solutions.getSolutionsCollector().toString());
                        System.out.println("CONGRATULATIONS, The number of SOLUTIONS is: " + solutions.getSolutionsCollector().size());
                    } else {
                        System.out.println("Sudoku is too hard to solve by this algorithm.");
                    }
                    // TODO to complete return proper value!!!!!
                    endTheGame = true;
                    result = false;
                    break;
                case "NEW": // -new game
                case "RESET": // TODO restart again - wczytac kopię i zaczac od poczatku
                    // TODO confirm to RESET values
                    // TODO method emptyTheBoard();
                    break;
                case "FULL":
                case "FINISH":
                case "FINISHED":
                case "PLAY":
                case "ALL":
                case "COMPLETE":
                    System.out.println(INFO_ABOUT_ADDING_POINTS);
                    System.out.println(board.toString());
                    // TODO method play(); and deepCopy as base for guessing and repeating
                    break;
                case "LOAD":
                case "EXAMPLE":
                    loadStoredExamples();
                    // TODO to complete the method loadStoredExamples();
                    break;
                case "AUTO":
                case "GENERATE":
                    // TODO method generateNewSudoku();
                    break;
                default:
//                    System.out.println("INFO: Option DEFAULT");
                    readEnteredNumbers(userInput);
            }
        }
        return result;
    }

    void loadStoredExamples() {
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

    void readEnteredNumbers(String userInput) {
        ArrayDeque<List<Integer>> userPointsToCheckBeforePutToBoardQueue;
        System.out.println("INFO: processing: " + userInput);
//        System.out.print("Enter next data: ");
        userInput = userInput.replaceAll(" ", "").replaceAll("\\.", ",");
        if (userInput.charAt(0) != 'R' && userInput.charAt(0) != 'P') {
            System.out.println("WARNING: Wrong input: expected command word or numbers followed by R or P.");
            return;
        }
        validate.setBoard(board);
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

    boolean putPointToBoard(int row, int column, int proposedValue) {
        board.getSudokuElement(row, column).setValue(proposedValue);
        board.getSudokuElement(row, column).getAvailableGuessValues().clear();
        return true;
    }
}
