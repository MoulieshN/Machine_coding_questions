package org.example.models;

import org.example.observers.ElevatorObserver;

public class FloorDisplay implements ElevatorObserver {
    private final int floorNumber;
    private final Elevator elevator;

    public FloorDisplay(int floorNumber, Elevator elevator) {
        this.floorNumber = floorNumber;
        this.elevator = elevator;
    }

    public void display(ElevatorEvent event){
        System.out.println("Floor Display - Floor: "+event.getFloor()+" | Elevator ID: "+event.getElevatorId()+" | Status: "+event.getType());
    }

    @Override
    public void update(ElevatorEvent event) {
        if(event.getElevatorId() == elevator.getElevatorId()){
            display(event);
        }
    }
}
