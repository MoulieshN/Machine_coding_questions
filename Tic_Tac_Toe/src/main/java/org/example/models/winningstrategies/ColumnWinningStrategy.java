package org.example.models.winningstrategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.enums.GameState;

import java.util.Stack;

public class ColumnWinningStrategy implements IWinningStrategy{
    @Override
    public GameState checkWinner(Board board) {
        Stack<Cell> stk = board.getMoveHistory();
        if(stk.isEmpty()) return GameState.IN_PROGRESS;

        Cell lastMove = stk.peek();
        int r = lastMove.getRow();
        int c = lastMove.getCol();
        int symbol = lastMove.getPlayer().getSymbol().getSymbolCharacter();

        for(int i=0; i<board.getSize(); i++){
            Cell cell = board.grid[i][c];

            if(cell == null || board.grid[i][c].getPlayer().getSymbol().getSymbolCharacter() != symbol) return GameState.IN_PROGRESS;
        }
        return GameState.COMPLETED;
    }
}
