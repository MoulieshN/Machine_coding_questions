package org.example.controllers;

import org.example.dtos.BillRequestDto;
import org.example.dtos.BillResponseDto;
import org.example.dtos.TicketRequestDto;
import org.example.dtos.TicketResponseDto;
import org.example.dtos.enums.ResponseStatus;
import org.example.models.Bill;
import org.example.models.Ticket;
import org.example.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketResponseDto issueTicket(TicketRequestDto ticketRequestDto) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        try{
            Ticket ticket = ticketService.issueTicket(ticketRequestDto.getVehicleNumber(),
                    ticketRequestDto.getVehicleOwnerName(),
                    ticketRequestDto.getVechicleType(),
                    ticketRequestDto.getGateID(),
                    ticketRequestDto.getParkingLotID());
            ticketResponseDto.setTicket(ticket);
            ticketResponseDto.setMessage("Ticket issued successfully");
            ticketResponseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            ticketResponseDto.setMessage("Exception occurred: " + e.getMessage());
            ticketResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return ticketResponseDto;
    }

    public BillResponseDto generateBill(BillRequestDto billRequestDto){
        BillResponseDto billResponseDto = new BillResponseDto();
        try{
            Bill bill = ticketService.issueBill(
                    billRequestDto.getTicketID(),
                    billRequestDto.getParkingLotID(),
                    billRequestDto.getGateID());
            billResponseDto.setStatus(ResponseStatus.SUCCESS);
            billResponseDto.setMessage("Bill generated successfully");
            billResponseDto.setBill(bill);
        }catch (Exception e){
            billResponseDto.setMessage("Exception occurred: " + e.getMessage());
            billResponseDto.setStatus(ResponseStatus.FAILURE);
        }

        return billResponseDto;
    }
}
