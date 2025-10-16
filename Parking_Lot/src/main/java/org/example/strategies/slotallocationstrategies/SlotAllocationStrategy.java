package org.example.strategies.slotallocationstrategies;

import org.example.models.ParkingLot;
import org.example.models.ParkingSlot;

public interface SlotAllocationStrategy {
    ParkingSlot allocateSlot(ParkingLot parkingLot);
}
