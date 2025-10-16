package org.example.strategies.feecalculationstrategies;

import org.example.enums.FeeCalculationStrategyEnum;
import org.example.models.Ticket;

import java.util.Date;

public class FeeCalculationStrategyFactory {
    public static FeeCalculationStrategy getFeeCalculationStrategy(FeeCalculationStrategyEnum strategyType) {
        return switch (strategyType) {
            case HOURLY -> new HourlyFeeCalculationStrategy();
            case VEHICLE_TYPE_BASED -> new VehicleFeeCalculationStrategy();
            default -> throw new IllegalArgumentException("Invalid strategy type: " + strategyType);
        };
    }
}
