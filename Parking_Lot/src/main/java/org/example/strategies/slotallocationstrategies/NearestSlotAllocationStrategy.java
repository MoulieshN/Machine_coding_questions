package org.example.strategies.slotallocationstrategies;

import org.example.enums.SlotStatus;
import org.example.models.ParkingFloor;
import org.example.models.ParkingLot;
import org.example.models.ParkingSlot;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy{
    @Override
    public ParkingSlot allocateSlot(ParkingLot parkingLot) {
        for(ParkingFloor floor: parkingLot.getFloors()){
            for(ParkingSlot slot: floor.getParkingSlots()){
                if(slot.getSlotStatus().equals(SlotStatus.AVAILABLE)) return slot;
            }
        }
        return null;
    }
}
