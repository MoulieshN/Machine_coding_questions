package org.example.repository;

import org.example.models.Vehicle;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleMap = new TreeMap<>();

    public Optional<Vehicle> getVehicleByLicensePlate(String licensePlate) {
        return Optional.ofNullable(vehicleMap.get(licensePlate));
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getVehicleNumber(), vehicle);
    }
}
