package org.example.models;

import org.example.observers.ElevatorObserver;

public class InsidePanel implements ElevatorObserver {
    private Elevator elevator;

    public InsidePanel(Elevator elevator) {
        this.elevator = elevator;
    }
    public void pressFloorButton(int floorNo){
        System.out.println("Inside Panel - Floor Button Pressed: "+floorNo+" in Elevator ID: "+elevator.getElevatorId());
        elevator.addRequest(floorNo);
    }

    @Override
    public void update(ElevatorEvent event) {
        if(event.getElevatorId() == elevator.getElevatorId()){
            System.out.println("Inside Panel - Elevator ID: "+event.getElevatorId()+" | Current Floor: "+event.getFloor()+" | Status: "+event.getType());
        }
    }
}
