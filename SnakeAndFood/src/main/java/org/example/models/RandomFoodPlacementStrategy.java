package org.example.models;

import org.example.enums.CellState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomFoodPlacementStrategy implements  IFoodPlacementStrategy {
    @Override
    public void PlaceFood(List<Item> items, GameBoard gameBoard) {
        List<Cell> availableSlots = new ArrayList<>();
        int n = gameBoard.getNoOfRows();
        int m = gameBoard.getNoOfCols();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Cell cell = gameBoard.getGrid()[i][j];
                if(cell.getState().equals(CellState.EMPTY)) availableSlots.add(cell);
            }
        }

        Collections.shuffle(availableSlots);

        int idx = 0;
        for(Item item: items){
            if(idx == availableSlots.size()) break;
            Cell cell = availableSlots.get(idx);
            cell.setItem(item);
            cell.setState(CellState.OCCUPIED);
            idx++;
        }
    }
}
