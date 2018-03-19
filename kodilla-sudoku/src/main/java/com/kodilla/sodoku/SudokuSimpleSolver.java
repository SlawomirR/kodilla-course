package com.kodilla.sodoku;

import java.util.*;

class SudokuSimpleSolver {
    static long SOLVER_ITERATION_COUNTER = 0;
    private SudokuBoard board;
    private boolean isSomethingFilled = true;
    private Cell cell;
    private int recursionNumber = 0;
    private Validators validate;
    boolean isSolved;
    private Solutions solutions;

    SudokuSimpleSolver(SudokuBoard board, Solutions solutions) {
        this.board = board;
        SOLVER_ITERATION_COUNTER = 0;
        this.solutions = solutions;
        cell = new Cell(0, 0);
        firstCheckSudokuQuality();
        sudokuSimpleSolver(cell);
        validate = new Validators();
        validate.setBoard(board);
    }

    private void sudokuSimpleSolver(Cell cell) throws IllegalArgumentException {
        SOLVER_ITERATION_COUNTER++;
        if (cell == null) {
            cell = null;
            System.out.println("getNextCell() reach THE END");
            isSomethingFilled = false;
        } else {
            if (board.getSudokuElement(cell.getRow(), cell.getCol()).getValue() > 0) {
                sudokuSimpleSolver(cell.getNextCell(cell));
            } else {
                isSomethingFilled = true;
            }
        }

        while (isSomethingFilled) {
            if (!isSomethingFilled) recursionNumber++;
            isSomethingFilled = false;
            tryingToSolveSomething();
        }

        if (!isSomethingFilled) recursionNumber++;

        if (cell != null) {
            if (cell.getRow() == 9) return;
            if (board.getSudokuElement(cell.getRow(), cell.getCol()).getValue() > 0) {
                sudokuSimpleSolver(cell.getNextCell(cell));
            } else {
                if (recursionNumber < 3) sudokuSimpleSolver(cell);
            }
        }
        System.out.println(System.lineSeparator() + "Number of iterations during solving the sudoku: " + SOLVER_ITERATION_COUNTER);
        System.out.println(board.toString());
        isSolved = isSolved(board);
        if (isSolved) {
            try {
                solutions.getSolutionsCollector().add(board.deepCopy());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isSolved(SudokuBoard board) {
        List<Boolean> isAllFilled = new ArrayList<>();
        int sudokuSum = board.getSudokuRowList().stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuElementList().stream())
                .mapToInt(SudokuElement::getValue)
                .peek(value -> {
                    if (value < 1) isAllFilled.add(false);
                })
                .sum();
        return sudokuSum == 405 && isAllFilled.size() == 0;
    }

    private boolean firstCheckSudokuQuality() {
        final int uniqueNumbersForOneSolution = 8;
        final int lowestQuantityForOneSolution = 17;
        Set<Integer> uniqueNumbersSet = new HashSet<>();
        long numbersQuantity = board.getSudokuRowList().stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuElementList().stream())
                .filter(sudokuElement -> sudokuElement.getValue() > 0)
                .peek(sudokuElement -> uniqueNumbersSet.add(sudokuElement.getValue()))
                .count();
        if (numbersQuantity < lowestQuantityForOneSolution || uniqueNumbersSet.size() < uniqueNumbersForOneSolution) {
            System.out.println("Expected is zero or more than one solution in your Sudoku because " +
                    "you put: " + numbersQuantity + " containing " + uniqueNumbersSet.size() + " unique once.");
            return false;
        } else {
            System.out.println("Sudoku you put has: " + numbersQuantity + " given numbers containing of " + uniqueNumbersSet.size() + " different digits.");
        }
        return true;
    }

    private Set<List<Integer>> reduceSolvingCellsNumberSet(int cellRow, int cellCol) {
        Set<List<Integer>> generatedSetForSolving = new HashSet<>();
        for (int universal = 0; universal < SudokuGame.SUDOKU_SIZE; universal++) {
            generatedSetForSolving.add(Arrays.asList(cellRow, universal));
            generatedSetForSolving.add(Arrays.asList(universal, cellCol));
        }
        int sector = (cellCol / SudokuGame.BOARD_SECTOR_SIZE) * SudokuGame.BOARD_SECTOR_SIZE;
        for (int col = sector; col < sector + SudokuGame.BOARD_SECTOR_SIZE; col++) {
            for (int row = sector; row < sector + SudokuGame.BOARD_SECTOR_SIZE; row++) {
                generatedSetForSolving.add(Arrays.asList(row, col));
            }
        }
        return generatedSetForSolving;
    }

    private void tryingToSolveSomething() throws IllegalArgumentException {
        for (List<Integer> variable : reduceSolvingCellsNumberSet(cell.getRow(), cell.getCol())) {
            int availableGuessValuesSize = board.getSudokuElement(cell.getRow(), cell.getCol()).getAvailableGuessValues().size();
            for (int i = availableGuessValuesSize - 1; i >= 0; i--) {
                SOLVER_ITERATION_COUNTER++;
                int valueFromAvailableToGuess = board.getSudokuElement(cell.getRow(), cell.getCol()).getAvailableGuessValues().get(i);
                boolean isOnBoard = validate.isValueAllowedToPut(variable.get(0), variable.get(1), valueFromAvailableToGuess);
                if (isOnBoard) {
                    if (availableGuessValuesSize == 1) {
                        if (validate.isValueAppearedAsPossibleForGuessing(cell.getRow(), cell.getCol(), valueFromAvailableToGuess)) {
                            throw new IllegalArgumentException("STATUS - Reconnect on brute-force method!!!!!");
                        }
                        board.getSudokuElement(cell.getRow(), cell.getCol()).setValue(valueFromAvailableToGuess);
                        board.getSudokuElement(cell.getRow(), cell.getCol()).getAvailableGuessValues().clear();
                        availableGuessValuesSize = board.getSudokuElement(cell.getRow(), cell.getCol()).getAvailableGuessValues().size();
                        isSomethingFilled = true;
                    }
                    board.getSudokuElement(cell.getRow(), cell.getCol()).getAvailableGuessValues().remove(i);
                    availableGuessValuesSize = board.getSudokuElement(cell.getRow(), cell.getCol()).getAvailableGuessValues().size();
                    isSomethingFilled = true;
//                    continue;
                } else {
                    if (!validate.isValueAppearedAsPossibleForGuessing(cell.getRow(), cell.getCol(), valueFromAvailableToGuess)) {
                        board.getSudokuElement(cell.getRow(), cell.getCol()).setValue(valueFromAvailableToGuess);
                        board.getSudokuElement(cell.getRow(), cell.getCol()).getAvailableGuessValues().clear();
                        availableGuessValuesSize = board.getSudokuElement(cell.getRow(), cell.getCol()).getAvailableGuessValues().size();
                        isSomethingFilled = true;
                    }

                }
            }
        }
    }
}

/*

    private void tryingToSolveSomethingInColumn() {
        for (int row = 0; row < SudokuGame.SUDOKU_SIZE; row++) {
            int availableGuessValuesSize = board.getSudokuElement(row, cell.getCol()).getAvailableGuessValues().size();
            for (int i = availableGuessValuesSize -1 ; i >= 0; i--) {
                SOLVER_ITERATION_COUNTER++;
                int valueFromAvailableToGuess = board.getSudokuElement(row, cell.getCol()).getAvailableGuessValues().get(i);
                if (validate.isValueAllowedToPut(row, cell.getCol(), valueFromAvailableToGuess)) {
                    if (availableGuessValuesSize == 1) {
                        if ( ! validate.isValueAppearedAsPossibleForGuessing(row, cell.getCol(), valueFromAvailableToGuess)) {
                            board.getSudokuElement(row, cell.getCol()).setValue(valueFromAvailableToGuess);
                            board.getSudokuElement(row, cell.getCol()).getAvailableGuessValues().clear();
                            availableGuessValuesSize = board.getSudokuElement(row, cell.getCol()).getAvailableGuessValues().size();
                            isSomethingFilled = true;
                        }
                    }
                } else {
                    if (availableGuessValuesSize == 1) {
                        throw new IllegalArgumentException("STATUS - Reconnect on brute-force method!!!!!");
                    }
                    board.getSudokuElement(row, cell.getCol()).getAvailableGuessValues().remove(i);
                    availableGuessValuesSize = board.getSudokuElement(row, cell.getCol()).getAvailableGuessValues().size();
                    isSomethingFilled = true;
                }
            }
        }
    }

    private void tryingToSolveSomethingInSector() {
        for (int c = (cell.getCol() / SudokuGame.BOARD_SECTOR_SIZE) * SudokuGame.BOARD_SECTOR_SIZE; c < SudokuGame.SUDOKU_SIZE; c++) {
            for (int r = (cell.getRow() / SudokuGame.BOARD_SECTOR_SIZE) * SudokuGame.BOARD_SECTOR_SIZE; r < SudokuGame.SUDOKU_SIZE; r++) {
                int availableGuessValuesSize = board.getSudokuElement(r, c).getAvailableGuessValues().size();
                for (int i = availableGuessValuesSize -1 ; i >= 0; i--) {
                    SOLVER_ITERATION_COUNTER++;
                    int valueFromAvailableToGuess = board.getSudokuElement(r, c).getAvailableGuessValues().get(i);
                    if (validate.isValueAllowedToPut(r, c, valueFromAvailableToGuess)) {
                        if (availableGuessValuesSize == 1) {
                            if ( ! validate.isValueAppearedAsPossibleForGuessing(r, c, valueFromAvailableToGuess)) {
                                board.getSudokuElement(r, c).setValue(valueFromAvailableToGuess);
                                board.getSudokuElement(r, c).getAvailableGuessValues().clear();
                                availableGuessValuesSize = board.getSudokuElement(r, c).getAvailableGuessValues().size();
                                isSomethingFilled = true;
                            }
                        }
                    } else {
                        if (availableGuessValuesSize == 1) {
                            throw new IllegalArgumentException("STATUS - Reconnect on brute-force method!!!!!");
                        }
                        board.getSudokuElement(r, c).getAvailableGuessValues().remove(i);
                        availableGuessValuesSize = board.getSudokuElement(r, c).getAvailableGuessValues().size();
                        isSomethingFilled = true;
                    }
                }
            }
        }
    }
*/
//}
