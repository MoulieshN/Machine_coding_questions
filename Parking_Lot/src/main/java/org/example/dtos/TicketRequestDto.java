package org.example.dtos;

import org.example.enums.VehicleType;

public class TicketRequestDto {
    private String vehicleNumber;
    private VehicleType vechicleType;
    private String vehicleOwnerName;
    private Long gateID;
    private Long parkingLotID;

    public Long getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(Long parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVechicleType() {
        return vechicleType;
    }

    public void setVechicleType(VehicleType vechicleType) {
        this.vechicleType = vechicleType;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public Long getGateID() {
        return gateID;
    }

    public void setGateID(Long gateID) {
        this.gateID = gateID;
    }
}
