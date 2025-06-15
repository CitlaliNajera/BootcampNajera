package org.example.Manager;

import org.example.Contract;
import org.example.Dealership;
import org.example.Vehicle;

public class ContractDataManager {

    public static void processContract(Dealership dealership, Contract contract) {
        Vehicle vehicle = contract.getVehicle();
        Vehicle vehicleInInventory = dealership.getVehicleByVIN(vehicle.getVin());

        if (vehicleInInventory != null) {
            dealership.removeVehicle(vehicleInInventory);
            System.out.println("Vehicle removed from inventory: " + vehicleInInventory);
        } else {
            System.out.println("Vehicle not found in inventory.");
        }

    }






}
