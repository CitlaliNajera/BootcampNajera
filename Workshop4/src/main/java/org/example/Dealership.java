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
            if (vehicle.getMake() == make && vehicle.getModel() == model) {
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
            if(vehicle.getColor()== color){
                vehicles.add(vehicle);
            }
        }
        return vehicles;

    }
    public  List<Vehicle> getVehiclesByMileage (int odometerStart,int odometerEnd){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer()<odometerStart && vehicle.getOdometer()>odometerEnd){
                vehicles.add(vehicle);
            }
        }
        return vehicles;

    }
    public  List<Vehicle> getVehiclesByType (String vehicleType){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory ){
            if(vehicle.getVehicleType()==vehicleType){
                vehicles.add(vehicle);
            }
        }
        return vehicles;

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


}

