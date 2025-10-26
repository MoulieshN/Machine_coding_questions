package org.example.models;

import org.example.controller.ElevatorController;
import org.example.enums.Direction;
import org.example.observers.ElevatorObserver;

public class FloorButton {
    private final int floorNumber;
    private final Elevator elevator;
    private ElevatorController controller;

    public FloorButton(int floorNumber, Elevator elevator, ElevatorController controller) {
        this.floorNumber = floorNumber;
        this.elevator = elevator;
        this.controller = controller;
    }

    public void PressUpButton() {
        ElevatorRequest request = new ElevatorRequest(floorNumber, Direction.UP);
        controller.submitRequest(request);
    }

    public void pressDownButton() {
        System.out.println("Floor Button - Down Button Pressed at Floor: " + floorNumber);
        ElevatorRequest request = new ElevatorRequest(floorNumber, Direction.DOWN);
        controller.submitRequest(request);
    }
}
