package org.example.strategies.feecalculationstrategies;

import org.example.models.Ticket;

import java.util.Date;

public class VehicleFeeCalculationStrategy implements FeeCalculationStrategy {


    @Override
    public int calculateFee(Date exitTime, Ticket ticket) {
        long diffMillis = exitTime.getTime() - ticket.getEntryTime().getTime();
        int hoursParked = (int) Math.ceil(diffMillis / (1000.0 * 60 * 60));
        int feePerHour;
        switch (ticket.getVehicle().getVehicleType()) {
            case CAR -> feePerHour = 20; // Assuming $20 per hour for cars
            case BIKE -> feePerHour = 10; // Assuming $10 per hour for bikes
            case TRUCK -> feePerHour = 30; // Assuming $30 per hour for trucks
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + ticket.getVehicle().getVehicleType());
        }
        return hoursParked * feePerHour;
    }
}
