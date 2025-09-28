package org.example;

import org.example.models.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Item normlFood1 = FoodFactory.createFood("normal");
        Item normlFood2 = FoodFactory.createFood("normal");
        Item bonusFood1 = FoodFactory.createFood("bonus");
        Item bonusFood2 = FoodFactory.createFood("bonus");
        Item bonusFood3 = FoodFactory.createFood("bonus");
        Item bonusFood4 = FoodFactory.createFood("bonus");
        Item normlFood3 = FoodFactory.createFood("normal");
        Item normlFood4 = FoodFactory.createFood("normal");

        List<Item> items = List.of(normlFood1, normlFood2, bonusFood1, bonusFood2, bonusFood3, bonusFood4, normlFood3, normlFood4);

        Item snakeHead = new SnakeBody("@");

        GameBoard board = new GameBoard(10, 10);

        SnakeGame game = new SnakeGame(board, 0, 0, new HumanMovementStrategy(), new RandomFoodPlacementStrategy(), snakeHead, items);

        System.out.println("===== SNAKE GAME =====");
        System.out.println(
                "Controls: W (Up), S (Down), A (Left), D (Right), Q (Quit)");
        System.out.println("Eat food to grow your snake and increase your score.");
        System.out.println("Don't hit the walls or bite yourself!");
        System.out.println("=======================");
        int totalScore = 0;
        while (true) {
            game.printBoard();

            int score = game.move();
            if (score == -1) {
                System.out.println("Game Over! Your final score is: " + totalScore);
                break;
            }
            totalScore += score;
            System.out.println("Current Score: " + totalScore);
        }
    }
}