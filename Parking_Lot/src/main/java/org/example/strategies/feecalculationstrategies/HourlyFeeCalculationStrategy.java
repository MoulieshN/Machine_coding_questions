package org.example.strategies.feecalculationstrategies;

import org.example.models.Ticket;

import java.util.Date;

public class HourlyFeeCalculationStrategy implements FeeCalculationStrategy{

    @Override
    public int calculateFee(Date exitTime, Ticket ticket) {
        long diffMillis = exitTime.getTime() - ticket.getEntryTime().getTime();
        int hoursParked = (int) Math.ceil(diffMillis / (1000.0 * 60 * 60));
        int feePerHour = 10; // Assuming a flat rate of $10 per hour
        return hoursParked * feePerHour;
    }
}
