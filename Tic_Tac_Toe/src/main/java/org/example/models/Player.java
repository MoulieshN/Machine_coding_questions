package org.example.models;

import org.example.models.enums.PlayerType;
import org.example.models.playerstrategies.PlayerStrategy;

public class Player {
    private String name;
    private PlayerStrategy playerStrategy;
    private Symbol symbol;
    public Player(String name, PlayerStrategy playerStrategy, Symbol symbol) {
        this.name = name;
        this.playerStrategy = playerStrategy;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
