package org.example.models.playerstrategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Player;

public interface PlayerStrategy {
    Cell makeMove(Board board, Player player);
}
