package org.example;

import org.example.models.*;
import org.example.models.playerstrategies.HumanPlayerStrategy;
import org.example.models.winningstrategies.ColumnWinningStrategy;
import org.example.models.winningstrategies.DiagonalWinningStrategy;
import org.example.models.winningstrategies.RowWinningStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1", new HumanPlayerStrategy(), new Symbol('X'));
        Player player2 = new Player("Player2", new HumanPlayerStrategy(), new Symbol('O'));
        Player player3 = new Player("Player3", new HumanPlayerStrategy(), new Symbol('S'));

        Board board = new Board(4);

        IGame game = new TicTacToeGame.Builder()
                .setBoard(board)
                .addPlayer(player1)
                .addPlayer(player2)
                .addPlayer(player3)
                .addWinningStrategies(new RowWinningStrategy())
                .addWinningStrategies(new ColumnWinningStrategy())
                .addWinningStrategies(new DiagonalWinningStrategy())
                .build();

        game.play();


    }
}