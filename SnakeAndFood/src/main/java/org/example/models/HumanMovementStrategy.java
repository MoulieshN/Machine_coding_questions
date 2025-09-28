package org.example.models;

import java.util.Scanner;

public class HumanMovementStrategy implements  IMovementStrategy{

    @Override
    public Cell getNextPosition(Cell currHead, GameBoard board) {
        System.out.println("Enter the direction (W/A/S/D): ");
        char direction = new Scanner(System.in).next().toUpperCase().charAt(0);

        int newRow = currHead.getRow();
        int newCol = currHead.getCol();

        switch (direction){
            case 'W' -> newRow--;
            case 'A' -> newCol--;
            case 'S' -> newRow++;
            case 'D' -> newCol++;
            default -> {
                System.out.println("Invalid direction! Please enter W, A, S, or D.");
                return getNextPosition(currHead, board);
            }
        }

        if(newRow < 0 || newRow >= board.getNoOfRows() || newCol < 0 || newCol >= board.getNoOfCols()){
            System.out.println("Move out of bounds! Try again.");
            return new Cell(newRow, newCol, null);
        }

        return board.getGrid()[newRow][newCol];

    }
}
