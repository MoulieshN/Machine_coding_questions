package org.example.models;

public interface IMovementStrategy {
    Cell getNextPosition(Cell currHead, GameBoard board);
}
