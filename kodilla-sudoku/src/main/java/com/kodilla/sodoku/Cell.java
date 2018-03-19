package com.kodilla.sodoku;

import lombok.Getter;

@Getter
public class Cell {
    private int row;
    private int col;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    Cell getNextCell(Cell cell) {
        SudokuSimpleSolver.SOLVER_ITERATION_COUNTER++;
        if (++cell.col > 8) {
            cell.col = 0;
            cell.row++;
        }
        if (cell.row > 8) {
            cell = null;
        }
        return cell;
    }

    @Override
    public String toString() {
        return "Cell [" + row + ", " + col + "]";
    }
}
