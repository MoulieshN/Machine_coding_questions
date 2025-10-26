package org.example.observers;

import org.example.models.ElevatorEvent;

public interface ElevatorObserver {
    public void update(ElevatorEvent event);
}
