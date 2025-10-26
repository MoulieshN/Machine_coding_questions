package org.example.strategies;

import org.example.enums.Direction;
import org.example.models.Elevator;
import org.example.models.ElevatorRequest;

import java.util.List;

public class NearestStrategy implements ElevatorSelectorStrategy{

    @Override
    public Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request) {
        Elevator bestElevator = elevators.get(0);
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevator: elevators){
            int distance = Math.abs(elevator.getCurrentFloor() - request.getFloorNumber());
            if(elevator.getDirection() == request.getDirection() || elevator.getDirection() == Direction.IDLE){
                if(distance < minDistance){
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        return bestElevator;
    }
}
