package org.example.dtos;

import org.example.dtos.enums.ResponseStatus;
import org.example.enums.VehicleType;
import org.example.models.Ticket;

public class TicketResponseDto {
    private Ticket ticket;
    private String message;
    private ResponseStatus status;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
