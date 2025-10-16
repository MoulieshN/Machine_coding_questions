package org.example.repository;

import org.example.enums.GateStatus;
import org.example.models.Gate;
import org.example.models.ParkingLot;

import java.util.*;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();

    // In an actual parking lot application,
    private Long parkingLotIdCounter = 1L;
    public Optional<ParkingLot> getParkingLotById(Long id) {
        return Optional.ofNullable(parkingLots.get(id));
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLot.setParkingLotID(parkingLotIdCounter++);
        parkingLots.put(parkingLot.getParkingLotID(), parkingLot);
    }

    public Optional<Gate> getGateById(Long gateID, Long parkingLotID) {
        Optional<ParkingLot> parkingLotOpt = getParkingLotById(parkingLotID);
        if(parkingLotOpt.isEmpty()) {
            return Optional.empty();
        }
        ParkingLot parkingLot = parkingLotOpt.get();
        for(Gate gate: parkingLot.getGates()){
           // gate id is long
              if(gate.getGateNumber().equals(gateID) && gate.getGateStatus().equals(GateStatus.OPEN)) {
                return Optional.of(gate);
              }
        }
        return Optional.empty();
    }
}
