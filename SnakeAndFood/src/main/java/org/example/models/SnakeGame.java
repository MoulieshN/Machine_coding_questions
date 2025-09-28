package org.example.models;

import org.example.enums.CellState;

import java.util.*;

public class SnakeGame {
    private GameBoard board;
    private Deque<Cell> snakeBody;
    private Set<Cell> snakeBodySet ;
    private IMovementStrategy movementStrategy;
    private IFoodPlacementStrategy foodPlacementStrategy;

    public SnakeGame(GameBoard board, int r, int c, IMovementStrategy movementStrategy, IFoodPlacementStrategy foodPlacementStrategy, Item snakeHead, List<Item> foodItems){
        this.board = board;
        this.movementStrategy = movementStrategy;
        this.foodPlacementStrategy = foodPlacementStrategy;
        this.snakeBody = new LinkedList<>();
        this.snakeBodySet = new HashSet<>();
        Cell head = board.getGrid()[r][c];
        head.setItem(snakeHead);
        snakeBody.addFirst(head);
        snakeBodySet.add(head);
        head.setState(CellState.OCCUPIED);

        foodPlacementStrategy.PlaceFood(foodItems, board);
    }

    public void setMovementStrategy(IMovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void setFoodPlacementStrategy(IFoodPlacementStrategy foodPlacementStrategy) {
        this.foodPlacementStrategy = foodPlacementStrategy;
    }

    public int move() {
        Cell currHead = this.snakeBody.peekFirst();
        System.out.println(currHead.getItem().getUtf());
        Cell newHead = movementStrategy.getNextPosition(currHead, board);

        int newRow = newHead.getRow();
        int newCol = newHead.getCol();

        // Check for wall collision
        if (newRow < 0 || newRow >= board.getNoOfRows() || newCol < 0 || newCol >= board.getNoOfCols()) {
            return -1; // Game over
        }

        // Check for self-collision and excluding the tail cell
        if (snakeBodySet.contains(newHead) && !newHead.equals(snakeBody.peekLast())) {
            return -1; // Game over
        }

        boolean ateFood = newHead.getState() == CellState.OCCUPIED && newHead.getItem() != null;
        int score = 0;
        if (ateFood){
            // the head of the deque is the current head of the snake
            // set the old cell's item to null
//            assert currHead != null;
            score = newHead.getItem().getPoints();

            Item item = currHead.getItem();
            item.setUtf("@");
            Item body = new SnakeBody("#");
            currHead.setItem(body);
            newHead.setItem(item);
            newHead.setState(CellState.OCCUPIED);
            snakeBody.addFirst(newHead);
            snakeBodySet.add(newHead);

        } else {
            currHead.getItem().setUtf("#");

            // Move the snake: add new head and remove tail
            Cell tail = snakeBody.removeLast(); // #
            snakeBodySet.remove(tail);
            tail.setState(CellState.EMPTY);
            tail.setItem(null);

//            assert currHead != null;
//            System.out.println(currHead.getItem().getUtf());
            Item item = new SnakeBody("@");
            newHead.setItem(item);
            newHead.setState(CellState.OCCUPIED);
            snakeBody.addFirst(newHead);
            snakeBodySet.add(newHead);
        }

        return score;
    }

    public void printBoard() {
        int rows = board.getNoOfRows();
        int cols = board.getNoOfCols();

        // Draw the board
        for (int i = 0; i < rows; i++) {
            // Top border for each row
            for (int j = 0; j < cols; j++) {
                System.out.print("+----");
            }
            System.out.println("+");

            // Print cells
            for (int j = 0; j < cols; j++) {
                Cell cell = board.getGrid()[i][j];
//                System.out.println(cell.getState());
                String symbol;
                if (cell.getState()==CellState.EMPTY) {
                    symbol = " ";
                } else {
                    symbol = cell.getItem().getUtf();
                }
                System.out.printf("| %-2s ", symbol); // fixed width cell
            }
            System.out.println("|");
        }

        // Bottom border
        for (int j = 0; j < cols; j++) {
            System.out.print("+----");
        }
        System.out.println("+");
    }

}
