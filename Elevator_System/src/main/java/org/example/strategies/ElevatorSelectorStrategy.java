package org.example.strategies;

import org.example.models.Elevator;
import org.example.models.ElevatorRequest;

import java.util.List;

public interface ElevatorSelectorStrategy {
    Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request);
}
