package org.example.models;

import org.example.models.enums.GameState;
import org.example.models.winningstrategies.IWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicTacToeGame implements  IGame{
    private Board board;
    private List<Player> players = new ArrayList<>();
    private List<IWinningStrategy> winningStrategies = new ArrayList<>();
    private int currentPlayer;
    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void play(){
        while(true){
            board.printBoard();

            Player currenPlayer = players.get(currentPlayer);
            Cell cell = currenPlayer.getPlayerStrategy().makeMove(board, currenPlayer);

            board.placeMove(cell);

            for(IWinningStrategy winningStrategy: winningStrategies){
                GameState gameState = winningStrategy.checkWinner(board);
                if (Objects.requireNonNull(gameState) == GameState.COMPLETED) {
                    this.gameState = gameState;
                    break;
                }
            }

            if(board.getMoveHistory().size() == board.getSize()*board.getSize()) {
                System.out.println("Match draw!!, no more moves to play");
                break;
            }
            if(gameState == GameState.COMPLETED){
                System.out.println("Player: " + currenPlayer.getSymbol().getSymbolCharacter() + " wins!!");
                break;
            }

            // to get the next player in the list
            this.currentPlayer = (this.currentPlayer+1)%(players.size());
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<IWinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<IWinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    pub

    public static class Builder{
        private Board board;
        private List<Player> players = new ArrayList<>();
        private List<IWinningStrategy> winningStrategies = new ArrayList<>();

        public Builder setBoard(Board board){
            this.board = board;
            return this;
        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategies(IWinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public TicTacToeGame build(){
            TicTacToeGame game = new TicTacToeGame();
            game.setBoard(this.board);
            game.setPlayers(this.players);
            game.setWinningStrategies(this.winningStrategies);
            game.setCurrentPlayer(0);
            game.setGameState(GameState.IN_PROGRESS);
            return game;
        }
    }
}
