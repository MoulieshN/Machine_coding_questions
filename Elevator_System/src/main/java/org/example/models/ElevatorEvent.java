package org.example.models;

import org.example.enums.Direction;

public class ElevatorEvent {
    public enum Type {MOVING, DOOR_OPENED, IDLE, ARRIVED };

    private final int floor;
    private final Direction direction;
    private final Type type;
    private int elevatorId;

    public ElevatorEvent(int floor, Direction direction, Type type, int elevatorId) {
        this.floor = floor;
        this.direction = direction;
        this.type = type;
        this.elevatorId = elevatorId;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public Type getType() {
        return type;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }
}
