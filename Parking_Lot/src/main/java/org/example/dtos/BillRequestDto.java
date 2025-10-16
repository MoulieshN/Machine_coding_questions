package org.example.dtos;

public class BillRequestDto {
    private Long ticketID;
    private Long parkingLotID;
    private Long gateID;

    public Long getTicketID() {
        return ticketID;
    }

    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
    }

    public Long getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(Long parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public Long getGateID() {
        return gateID;
    }

    public void setGateID(Long gateID) {
        this.gateID = gateID;
    }
}
