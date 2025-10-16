package org.example.service;

import org.example.enums.*;
import org.example.models.*;
import org.example.repository.BillRepository;
import org.example.repository.ParkingLotRepository;
import org.example.repository.TicketRepository;
import org.example.repository.VehicleRepository;
import org.example.strategies.feecalculationstrategies.FeeCalculationStrategy;
import org.example.strategies.feecalculationstrategies.FeeCalculationStrategyFactory;
import org.example.strategies.slotallocationstrategies.SlotAllocationStrategy;
import org.example.strategies.slotallocationstrategies.SlotAllocationStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    private BillRepository billRepository;

    public TicketService(VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository,
                         BillRepository billRepository) {
        this.billRepository = billRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
                              String vehicleOwnerName,
                              VehicleType vehicleType,
                              Long gateID,
                              Long parkingLotID) {

        // Create a new TicketObject
        Ticket ticket = new Ticket();

        // Set the entry time to the ticket which marks the time of entry of the vehicle
        ticket.setEntryTime(new Date());

        Optional<Gate> entryGate = parkingLotRepository.getGateById(gateID, parkingLotID);
        if(entryGate.isEmpty()) {
            System.out.println("Gate not found with ID: " + gateID + " in Parking Lot ID: " + parkingLotID);
            throw new IllegalArgumentException("Invalid Gate ID");
        }
        Gate gate = entryGate.get();
        ticket.setGeneratedAtGate(gate);
        ticket.setGeneratedByOperator(gate.getOperator());
        System.out.println("Gate found with ID: " + gateID + " in Parking Lot ID: " + parkingLotID);
        // Create a new Vehicle Object and set the details
        Optional<Vehicle> vehicleOpt = vehicleRepository.getVehicleByLicensePlate(vehicleNumber);
        if(vehicleOpt.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setNameOfOwner(vehicleOwnerName);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.addVehicle(vehicle);
            System.out.println("New Vehicle created with number: " + vehicleNumber);
            ticket.setVehicle(vehicle);
        } else {
            System.out.println("Existing Vehicle found with number: " + vehicleNumber);
            ticket.setVehicle(vehicleOpt.get());
        }

        // Get an available parking slot from the parking lot service
        // We have the parkingLot id from the gate object
        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotById(parkingLotID);
        if(parkingLot.isEmpty()) {
            throw new IllegalArgumentException("Invalid Parking Lot ID");
        }
        SlotAllocationStrategyEnum slotAllocationStrategy = parkingLot.get().getSlotAllocationStrategyType();
        SlotAllocationStrategy slotAllocationStrategyObj = SlotAllocationStrategyFactory.getStrategy(slotAllocationStrategy);

        ParkingSlot parkingSlot = slotAllocationStrategyObj.allocateSlot(parkingLot.get());

        parkingSlot.setSlotStatus(SlotStatus.OCCUPIED);
        ticket.setAssignedSlot(parkingSlot);

        // Save the ticket object in the repository
        ticketRepository.addTicket(ticket);
        System.out.println("Ticket issued with number: " + ticket.getTicketNumber() + " for vehicle number: " + vehicleNumber);
        return ticket;
    }


    public Bill issueBill(Long ticketNumber, Long parkingLotID, Long exitGateID) {
        Optional<Ticket> ticketOptional = ticketRepository.getTicketById(ticketNumber);
        if(ticketOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid Ticket ID");
        }
        Ticket ticket = ticketOptional.get();
        ParkingSlot parkingSlot = ticket.getAssignedSlot();
        parkingSlot.setSlotStatus(SlotStatus.AVAILABLE);

        Date exitTime = new Date();
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotById(parkingLotID);
        if(parkingLotOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid Parking Lot ID");
        }

        ParkingLot parkingLot = parkingLotOptional.get();
        FeeCalculationStrategyEnum feeCalculationStrategyEnum = parkingLot.getFeeCalculationStrategyType();
        FeeCalculationStrategy feeCalculationStrategy = FeeCalculationStrategyFactory.getFeeCalculationStrategy(feeCalculationStrategyEnum);
        int calculatedFee = feeCalculationStrategy.calculateFee(exitTime, ticket);

        Optional<Gate> exitGateOpt = parkingLotRepository.getGateById(exitGateID, parkingLotID);
        if(exitGateOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid Exit Gate ID");
        }

        Gate exitGate = exitGateOpt.get();
        Operator exitOperator = exitGate.getOperator();

        // TODO: Should handle payments
        Bill bill = new Bill();
        bill.setTicket(ticket);
        bill.setBillStatus(BillStatus.PAID);
        bill.setAmount((long) calculatedFee);
        bill.setExitTime(exitTime);
        bill.setGeneratedByOperator(exitOperator);
        bill.setGeneratedAtGate(exitGate);

        billRepository.save(bill);
        return bill;
    }
}
