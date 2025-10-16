package org.example.strategies.feecalculationstrategies;

import org.example.models.Ticket;

import java.util.Date;

public interface FeeCalculationStrategy {
    int calculateFee(Date exitTime, Ticket ticket);
}
