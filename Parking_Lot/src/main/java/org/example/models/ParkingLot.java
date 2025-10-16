package org.example.models;

import java.util.List;

import org.example.enums.FeeCalculationStrategyEnum;
import org.example.enums.ParkingLotStatus;
import org.example.enums.SlotAllocationStrategyEnum;
import org.example.enums.VehicleType;

public class ParkingLot extends  BaseModel{
    private Long ParkingLotID;
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private List<VehicleType> vehicleAllowed;
    private ParkingLotStatus status;
    private FeeCalculationStrategyEnum feeCalculationStrategyType;
    private SlotAllocationStrategyEnum slotAllocationStrategyType;

    public Long getParkingLotID() {
        return ParkingLotID;
    }

    public void setParkingLotID(Long parkingLotID) {
        ParkingLotID = parkingLotID;
    }

    public SlotAllocationStrategyEnum getSlotAllocationStrategyType() {
        return slotAllocationStrategyType;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategyEnum slotAllocationStrategyType) {
        this.slotAllocationStrategyType = slotAllocationStrategyType;
    }

    public FeeCalculationStrategyEnum getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategyEnum feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public List<VehicleType> getVehicleAllowed() {
        return vehicleAllowed;
    }

    public void setVehicleAllowed(List<VehicleType> vehicleAllowed) {
        this.vehicleAllowed = vehicleAllowed;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }
}
