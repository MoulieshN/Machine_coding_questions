package org.example.models;

import org.example.enums.CellState;

public class GameBoard {
    private Cell[][] grid;
    private int noOfRows;
    private int noOfCols;

    public GameBoard(int noOfRows, int noOfCols) {
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        this.grid = new Cell[noOfRows][noOfCols];
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                grid[i][j] = new Cell(i, j, null);

            }
        }
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getNoOfCols() {
        return noOfCols;
    }

    public void setNoOfCols(int noOfCols) {
        this.noOfCols = noOfCols;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }
}
