package org.example.models.playerstrategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Player;
import org.example.models.enums.PlayerType;

import java.util.Scanner;

public class HumanPlayerStrategy implements  PlayerStrategy{
    Scanner scanner;
    private PlayerType playerType;
    public HumanPlayerStrategy(){
        this.scanner = new Scanner(System.in);
        this.playerType = PlayerType.HUMAN;
    }
    @Override
    public Cell makeMove(Board board, Player player){
        int size = board.getSize();
        while (true) {
            // Get the player's move
            System.out.println("Enter your move:- row and col [0-"+(size-1)+"]: ");
            try{
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Cell cell = new Cell(row, col, player);
                if(board.isValidMove(cell)) return cell;

                System.out.println("Invalid move: try again!!");
            }catch (Exception e) {
                System.out.println(
                        "Invalid input. Please enter row and column as numbers.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }

    private PlayerType getPlayerType(){
        return this.playerType;
    }
}
