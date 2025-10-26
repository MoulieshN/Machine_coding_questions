package org.example.controller;

import org.example.models.*;
import org.example.strategies.ElevatorSelectorStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElevatorController {
    private List<Elevator> elevators = new ArrayList<>();
    private Map<Integer, List<FloorButton>> floorButtons = new HashMap<>();
    private ElevatorSelectorStrategy elevatorSelectorStrategy;
    public ElevatorController(int noOfElevators, int noOfFloors, ElevatorSelectorStrategy elevatorSelectorStrategy) {
        this.elevatorSelectorStrategy = elevatorSelectorStrategy;
        // Initialize elevators

        for(int i = 0; i < noOfElevators; i++) {
            Elevator elevator = new Elevator(i);
            for(int j = 0; j < noOfFloors; j++) {
                FloorDisplay floorDisplay = new FloorDisplay(j, elevator);
                FloorButton floorButton = new FloorButton(j, elevator, this);

                // add floor display as observer to elevator
                elevator.addObserver(floorDisplay);

                if(!floorButtons.containsKey(j)){
                    floorButtons.put(j, new ArrayList<>());
                }
                floorButtons.get(j).add(floorButton);
            }

            elevators.add(elevator);
            Thread elevatorThread = new Thread(elevator);
            elevatorThread.start();
        }
    }

    public void submitRequest(ElevatorRequest request){
        // Strategy pattern will come here, for now we will just assign the first elevator
        Elevator bestElevator = elevatorSelectorStrategy.selectElevator(elevators, request);
        bestElevator.addRequest(request.getFloorNumber());

    }

    public void pressUpButtonAtFloor(int floorNo, int elevatorId){
        floorButtons.get(floorNo).get(elevatorId).PressUpButton();
    }

    public void pressDownButtonAtFloor(int floorNo, int elevatorId){
        floorButtons.get(floorNo).get(elevatorId).pressDownButton();
    }

    public void pressInsideButton(int floorNo, int elevatorId){
        InsidePanel insidePanel = elevators.get(elevatorId).getInsidePanel();
        insidePanel.pressFloorButton(floorNo);
    }
}
