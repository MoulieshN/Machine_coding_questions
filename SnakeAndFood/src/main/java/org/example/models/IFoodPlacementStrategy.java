package org.example.models;

import java.util.List;

public interface IFoodPlacementStrategy {
    void PlaceFood(List<Item> items, GameBoard gameBoard);
}
