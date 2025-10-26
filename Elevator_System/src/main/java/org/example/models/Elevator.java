package org.example.models;
import org.example.enums.Direction;
import org.example.observers.ElevatorObserver;

import java.util.*;

public class Elevator implements  Runnable{
    private int elevatorId;
    private int currentFloor;
    private Direction direction;
    private InsidePanel insidePanel;

    private List<ElevatorObserver> observers = new ArrayList<>();

    private PriorityQueue<Integer> upRequests = new PriorityQueue<>();
    private PriorityQueue<Integer> downRequests = new PriorityQueue<>((a, b) -> b - a);

    private volatile  boolean running = true;

    public Elevator(int elevatorId) {
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.insidePanel = new InsidePanel(this);
        addObserver(insidePanel);
    }

    public void addObserver(ElevatorObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(ElevatorEvent.Type type){
        ElevatorEvent elevatorEvent = new ElevatorEvent(currentFloor, direction, type, elevatorId);
        for(ElevatorObserver observer : observers){
            observer.update(elevatorEvent);
        }
    }

    public synchronized void addRequest(int floorNo){
        if(floorNo > currentFloor){
            upRequests.add(floorNo);
        } else if(floorNo < currentFloor){
            downRequests.add(floorNo);
        }else{
            System.out.println("Elevator " + elevatorId + " is already at floor " + floorNo);
        }

        if(direction == Direction.IDLE){
            direction = floorNo > currentFloor ? Direction.UP : Direction.DOWN;
        }
    }

    @Override
    public void run() {
        while(running){
            try{
                Integer nextFloor = getNextFloor();
                if(nextFloor != null){
                    moveToFloor(nextFloor);
                } else {
                    // No requests, elevator is idle
                    System.out.println("Elevator " + elevatorId + " is idle at floor " + currentFloor);
                    Thread.sleep(200); // Sleep for a while before checking again
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Elevator " + elevatorId + " interrupted.");
            }
        }
    }

    private synchronized Integer getNextFloor(){
       return switch (direction){
              case UP -> upRequests.poll();
              case DOWN -> downRequests.poll();
              case IDLE -> null;
       };
    }

    private void moveToFloor(Integer floorNo) throws InterruptedException {
        while(currentFloor != floorNo){
            currentFloor += (direction == Direction.UP) ? 1 : -1;
            notifyObservers(ElevatorEvent.Type.MOVING);
        }

        notifyObservers(ElevatorEvent.Type.ARRIVED);
        Thread.sleep(200);

        notifyObservers(ElevatorEvent.Type.DOOR_OPENED);
        Thread.sleep(200);

        notifyObservers(ElevatorEvent.Type.MOVING);
        // if queue is empty then change the direction
        synchronized (this){
            if(upRequests.isEmpty() && downRequests.isEmpty()){
                direction = Direction.IDLE;
                notifyObservers(ElevatorEvent.Type.IDLE);
            } else if(direction == Direction.UP && upRequests.isEmpty()){
                direction = Direction.DOWN;
            } else if(direction == Direction.DOWN && downRequests.isEmpty()){
                direction = Direction.UP;
            }
        }
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public InsidePanel getInsidePanel() {
        return insidePanel;
    }
}
