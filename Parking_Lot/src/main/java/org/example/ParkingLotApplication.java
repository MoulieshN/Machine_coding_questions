package org.example;

import org.example.controllers.TicketController;
import org.example.dtos.BillRequestDto;
import org.example.dtos.BillResponseDto;
import org.example.dtos.TicketRequestDto;
import org.example.dtos.TicketResponseDto;
import org.example.enums.VehicleType;
import org.example.models.Ticket;

import java.util.Scanner;

public class ParkingLotApplication {
    private TicketController ticketController;
    public ParkingLotApplication(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    public void generateRequest(){
        // Initialize Scanner to take input from console
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter command (or type 'exit' to quit): ");
            String command = scanner.nextLine();
            if(command.equalsIgnoreCase("exit")){
                System.out.println("Exiting the system. Goodbye!");
                break;
            }
            System.out.println("Enter vehicle number: ");
            String vehicleNumber = scanner.nextLine();
            System.out.println("Enter vehicle owner name: ");
            String vehicleOwnerName = scanner.nextLine();
            System.out.println("Enter vehicle type (CAR/BIKE): ");
            String vehicleTypeStr = scanner.nextLine();
            VehicleType vehicleType;
            if(vehicleTypeStr.equalsIgnoreCase("CAR")){
                vehicleType = VehicleType.CAR;
            } else if(vehicleTypeStr.equalsIgnoreCase("BIKE")){
                vehicleType = VehicleType.BIKE;
            } else {
                System.out.println("Invalid vehicle type. Please enter CAR or BIKE.");
                continue;
            }

            System.out.println("Enter gate ID (1-6): ");
            Long gateID = scanner.nextLong();

            TicketRequestDto ticketRequestDto = new TicketRequestDto();
            ticketRequestDto.setGateID(gateID);
            ticketRequestDto.setParkingLotID(1L); // Assuming only one parking lot with ID 1
            ticketRequestDto.setVehicleNumber(vehicleNumber);
            ticketRequestDto.setVehicleOwnerName(vehicleOwnerName);
            ticketRequestDto.setVechicleType(vehicleType);

            // Creating a ticket for the vehicle
            TicketResponseDto ticketResponseDto = ticketController.issueTicket(ticketRequestDto);

            System.out.println("***************************************** ");
            System.out.println("************ TICKET DETAILS ************* ");
            System.out.println("TicketNo: "+ticketResponseDto.getTicket().getTicketNumber());
            System.out.println("VehicleNo: "+ticketResponseDto.getTicket().getVehicle().getVehicleNumber());
            System.out.println("VehicleOwner: "+ticketResponseDto.getTicket().getVehicle().getNameOfOwner());
            System.out.println("VehicleType: "+ticketResponseDto.getTicket().getVehicle().getVehicleType());
            System.out.println("EntryTime: "+ticketResponseDto.getTicket().getEntryTime());
            System.out.println("GeneratedAtGate: "+ticketResponseDto.getTicket().getGeneratedAtGate().getGateNumber());
            System.out.println("GeneratedByOperator: "+ticketResponseDto.getTicket().getGeneratedByOperator().getName());
            System.out.println("AssignedSlot: "+ticketResponseDto.getTicket().getAssignedSlot().getSlotNumber());
            System.out.println("******************************************** ");

            System.out.println();
            System.out.println();

            // Generate Bill for the vehicle
            BillRequestDto billRequestDto = new BillRequestDto();
            System.out.println("Enter exit gate ID for bill generation (1-6): ");
            Long exitGateID = scanner.nextLong();
            billRequestDto.setGateID(exitGateID);
            billRequestDto.setParkingLotID(1L); // Assuming only one parking lot with ID 1
            billRequestDto.setTicketID(ticketResponseDto.getTicket().getTicketNumber());
            BillResponseDto billResponseDto = ticketController.generateBill(billRequestDto);

            System.out.println("***************************************** ");
            System.out.println("************* BILL DETAILS ************** ");
            System.out.println("BillNo: "+billResponseDto.getBill().getBillNumber());
            System.out.println("TicketNo: "+billResponseDto.getBill().getTicket().getTicketNumber());
            System.out.println("VehicleNo: "+billResponseDto.getBill().getTicket().getVehicle().getVehicleNumber());
            System.out.println("VehicleOwner: "+billResponseDto.getBill().getTicket().getVehicle().getNameOfOwner());
            System.out.println("VehicleType: "+billResponseDto.getBill().getTicket().getVehicle().getVehicleType());
            System.out.println("EntryTime: "+billResponseDto.getBill().getTicket().getEntryTime());
            System.out.println("ExitTime: "+billResponseDto.getBill().getExitTime());
            System.out.println("TotalAmount: "+billResponseDto.getBill().getAmount());
            System.out.println("GeneratedAtGate: "+billResponseDto.getBill().getGeneratedAtGate().getGateNumber());
            System.out.println("GeneratedByOperator: "+billResponseDto.getBill().getGeneratedByOperator().getName());
            System.out.println("***************************************** ");
            scanner.nextLine(); // consume the newline
        }


    }
}
