package org.example.models;

import org.example.enums.Direction;
import org.example.enums.RequestType;

public class ElevatorRequest {
    private final int floorNumber;
    private final Direction direction;
    private final RequestType requestType;

    public ElevatorRequest(int floorNumber, Direction direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
        this.requestType = RequestType.OUTSIDE;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    public RequestType getRequestType() {
        return requestType;
    }
}
