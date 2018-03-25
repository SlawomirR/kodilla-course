package com.kodilla.sodoku;

final class DefiniteSolvingMethod {
    private Board currBoard;
    private Solutions solutions;

    DefiniteSolvingMethod(Board board, Solutions solutions) {
        this.solutions = solutions;
        try {
            currBoard = board.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    boolean definiteSolve() {
        long begin = System.currentTimeMillis();
        boolean solved = solve(new Cell(0, 0));
        long end = System.currentTimeMillis();
        if (solved) {
            try {
                solutions.getSolutionsCollector().add(currBoard.deepCopy());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Solving sudoku by DefiniteSolvingMethod takes additional: " + (end - begin) + "ms");
        return solved;
    }

    private class Cell {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean isValid(Cell cell, int value) {
        if (currBoard.getElement(cell.row, cell.col).getValue() > 0) {
            throw new RuntimeException("Cannot call for cell which already has a value");
        }
        for (int col = 0; col < 9; col++) {
            if (currBoard.getElement(cell.row, col).getValue() == value) {
                return false;
            }
        }
        for (int row = 0; row < 9; row++) {
            if (currBoard.getElement(row, cell.col).getValue() == value) {
                return false;
            }
        }
        int minRowSecBound = Processor.BOARD_SECTOR_SIZE * (cell.row / Processor.BOARD_SECTOR_SIZE);
        int minColSecBound = Processor.BOARD_SECTOR_SIZE * (cell.col / Processor.BOARD_SECTOR_SIZE);
        int maxRowSecBound = minRowSecBound + Processor.BOARD_SECTOR_SIZE - 1;
        int maxColSecBound = minColSecBound + Processor.BOARD_SECTOR_SIZE - 1;
        for (int r = minRowSecBound; r <= maxRowSecBound; r++) {
            for (int c = minColSecBound; c <= maxColSecBound; c++) {
                if (currBoard.getElement(r, c).getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private Cell getNextCell(Cell cur) {
        int row = cur.row;
        int col = cur.col;

        if (++col > 8) {
            col = 0;
            row++;
        }
        if (row > 8) {
            return null;
        }
        return new Cell(row, col);
    }

    private boolean solve(Cell cur) {
        if (cur == null) {
            return true;
        }
        if (currBoard.getElement(cur.row, cur.col).getValue() > 0) {
            return solve(getNextCell(cur));
        }
        for (int guessValue = 1; guessValue <= Processor.SUDOKU_SIZE; guessValue++) {
            boolean valid = isValid(cur, guessValue);
            if (!valid) {
                continue;
            }
            currBoard.getElement(cur.row, cur.col).setValue(guessValue);
            boolean solved = solve(getNextCell(cur));
            if (solved) {
                return true;
            } else {
                currBoard.getElement(cur.row, cur.col).setValue(0); //reset
            }
        }
        return false;
    }
}
