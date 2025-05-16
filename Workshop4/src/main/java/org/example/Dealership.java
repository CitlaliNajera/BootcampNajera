package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }
    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory) {
            if (vehicle.getPrice() > min && vehicle.getPrice() < max) {
                vehicles.add(vehicle);

            }
        }
        return vehicles;

    }
    public  List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory) {
            if (vehicle.getMake().toLowerCase().contains(make.toLowerCase()) &&
                    vehicle.getModel().toLowerCase().contains(model.toLowerCase())) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;

    }
    public  List<Vehicle> getVehiclesByYear(int yearStart, int yearEnd ){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getYear()>=yearStart && vehicle.getYear()<=yearEnd) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public  List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().toLowerCase().contains(color.toLowerCase())){
                vehicles.add(vehicle);
            }
        }
        return vehicles;

    }
    public  List<Vehicle> getVehiclesByMileage (int odometerLow,int odometerHigh){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer()>odometerLow && vehicle.getOdometer()<odometerHigh){
                vehicles.add(vehicle);
            }
        }
        return vehicles;

    }
    public  List<Vehicle> getVehiclesByType (String vehicleType){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory ){
            if(vehicle.getVehicleType().toLowerCase().contains(vehicleType.toLowerCase())){
                vehicles.add(vehicle);
            }
        }
        return vehicles;

    }
    public Vehicle getVehicleByVIN (int vin){
        for(Vehicle vehicle : inventory){
            if(vehicle.getVin() == vin){
               return vehicle;
            }
        }
        return null;

    }

    public List<Vehicle> getAllVehicles(){
        return this.inventory;
    }


    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);

    }
    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);

    }
    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            System.out.println("\nDisplaying All Vehicles:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.toString());
            }
        }
    }
    public void displayAllVehicles(Dealership dealership) {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }


}

