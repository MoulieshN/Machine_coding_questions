package org.example;

import org.example.controllers.TicketController;
import org.example.dtos.TicketRequestDto;
import org.example.enums.*;
import org.example.models.*;
import org.example.repository.BillRepository;
import org.example.repository.ParkingLotRepository;
import org.example.repository.TicketRepository;
import org.example.repository.VehicleRepository;
import org.example.service.TicketService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Lot Management System!");
        System.out.println("Initializing Database...");

        // Initialize Parking Lot repositories
        VehicleRepository vehicleRepository = new VehicleRepository();
        BillRepository billRepository = new BillRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();


        ParkingLot parkingLot1 = new ParkingLot();
        List<ParkingFloor> floors = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            ParkingFloor floor = new ParkingFloor();
            floor.setFloorNumber("F" + i);
            floor.setFloorStatus(ParkingFloorStatus.OPEN);
            List<ParkingSlot> slots = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                ParkingSlot slot = new ParkingSlot();
                slot.setSlotNumber("S" + j);
                slot.setVehicleType(j <= 5 ? VehicleType.CAR : VehicleType.BIKE);
                slot.setSlotStatus(SlotStatus.AVAILABLE);
                slot.setParkingFloor(floor);
                slots.add(slot);
            }
            floor.setParkingSlots(slots);
            floor.setSupportedVehicleTypes(Arrays.asList(VehicleType.CAR, VehicleType.BIKE));
            floors.add(floor);
        }

        List<Gate> gates = new ArrayList<>();
        for(int i=0; i<6; i++){
            Operator operator = new Operator();
            operator.setName("Operator" + (i+1));
            operator.setOperatorId("OP" + (i+1));

            Gate gate = new Gate();
            gate.setGateNumber((long) (i+1));
            gate.setOperator(operator);
            gate.setGateStatus(GateStatus.OPEN);
            gate.setGateType(i%2==0 ? org.example.enums.GateType.ENTRY : org.example.enums.GateType.EXIT);

            gates.add(gate);
        }

        parkingLot1.setFloors(floors);
        parkingLot1.setGates(gates);
        parkingLot1.setVehicleAllowed(Arrays.asList(VehicleType.CAR, VehicleType.BIKE));
        parkingLot1.setStatus(ParkingLotStatus.OPEN);
        parkingLot1.setFeeCalculationStrategy(FeeCalculationStrategyEnum.HOURLY);
        parkingLot1.setSlotAllocationStrategy(SlotAllocationStrategyEnum.NEAREST);

        parkingLotRepository.addParkingLot(parkingLot1);

        // Initialize Service
        TicketService ticketService = new TicketService(vehicleRepository, parkingLotRepository, ticketRepository, billRepository);

        // Initialize controller
        TicketController ticketController = new TicketController(ticketService);

        ParkingLotApplication app = new ParkingLotApplication(ticketController);
        app.generateRequest();
    }
}