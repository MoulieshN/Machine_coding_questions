package org.example.models;

import java.util.Stack;

public class Board {
    private final int size;
    public Cell[][] grid;
    private Stack<Cell> moveHistory;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        this.moveHistory = new Stack<>();
    }

    public Stack<Cell> getMoveHistory(){
        return moveHistory;
    }

    public int getSize() {
        return size;
    }

    public boolean isValidMove(Cell cell){
        int row = cell.getRow();
        int col = cell.getCol();
        if(row < 0 || col < 0 || row >=size || col >= size) return false;
        return grid[row][col] == null;
    }

    public void placeMove(Cell cell){
        grid[cell.getRow()][cell.getCol()] = cell;
        moveHistory.add(cell);
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = grid[i][j];
                if(cell == null) System.out.print(" . ");
                else System.out.print(" "+cell.getPlayer().getSymbol().getSymbolCharacter()+" ");
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public void undo(){
        if(moveHistory.isEmpty()){
            System.out.println("No previous to undo!!");
            return;
        }
        Cell prevMove = moveHistory.pop();
        int r = prevMove.getRow();
        int c = prevMove.getCol();

        this.grid[r][c] = null;
        System.out.println("Undid the past tense!!");

    }
}
