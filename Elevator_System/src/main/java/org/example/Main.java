package org.example;

import org.example.controller.ElevatorController;
import org.example.strategies.ElevatorSelectorStrategy;
import org.example.strategies.NearestStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ElevatorSelectorStrategy strategy = new NearestStrategy();
        ElevatorController controller = new ElevatorController(3, 4, strategy);
        controller.pressDownButtonAtFloor(2, 0);
        controller.pressInsideButton(3, 0);
        controller.pressUpButtonAtFloor(1, 2);
        controller.pressInsideButton(4, 2);
    }
}