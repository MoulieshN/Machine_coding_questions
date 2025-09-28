package org.example.models.winningstrategies;

import org.example.models.Board;
import org.example.models.enums.GameState;

public interface IWinningStrategy {
    GameState checkWinner(Board board);
}
