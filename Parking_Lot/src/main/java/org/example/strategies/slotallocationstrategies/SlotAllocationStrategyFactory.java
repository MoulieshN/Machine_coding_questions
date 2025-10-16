package org.example.strategies.slotallocationstrategies;

import org.example.enums.SlotAllocationStrategyEnum;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getStrategy(SlotAllocationStrategyEnum strategyType) {
        return switch (strategyType) {
            case NEAREST -> new NearestSlotAllocationStrategy();
            case RANDOM -> new RandomSlotAllocationStrategy();
            default -> throw new IllegalArgumentException("Invalid strategy type");
        };
    }
}
