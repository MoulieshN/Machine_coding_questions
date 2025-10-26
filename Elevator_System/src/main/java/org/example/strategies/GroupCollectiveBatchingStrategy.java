package org.example.strategies;

import org.example.models.Elevator;
import org.example.models.ElevatorRequest;

import java.util.List;

public class GroupCollectiveBatchingStrategy implements ElevatorSelectorStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request) {
        // Implementation of group collective batching strategy
        return null; // Placeholder return
    }
}
