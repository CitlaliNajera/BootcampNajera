package org.example.Manager;

import org.example.Dealership;
import org.example.Vehicle;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {

    public static void saveDealership(Dealership dealership){
        try{
        FileWriter fileWrote = new FileWriter("src/main/resources/inventory.csv");

        String dealershipHeader = String.format("%s|%s|%s %n", dealership.getName(),dealership.getAddress(),dealership.getPhone());
        fileWrote.write(dealershipHeader);

        for(Vehicle vehicle : dealership.getAllVehicles()) {
            String row = String.format("%d|%d|%s|%s|%s|%s|%d|%f %n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

            fileWrote.write(row);
        }
        fileWrote.close();
        } catch (IOException e) {
            System.out.println("Failed to save csv file");
        }
    }

    public static Dealership getDealership(){
        Dealership dealership = null;
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String dealershipInfo = bufferedReader.readLine();
            if(dealershipInfo != null){
                String [] dealershipDetails = dealershipInfo.split("\\|");


                       String name=  dealershipDetails[0].trim();
                       String address=  dealershipDetails[1].trim();
                       String phone =  dealershipDetails[2].trim();

                       dealership = new Dealership(name,address,phone,vehicleList);

            }

            String input;
            while((input = bufferedReader.readLine()) != null){
                String[] row = input.split("\\|");


                int vin = Integer.parseInt(row[0]);
                int year = Integer.parseInt(row[1]);
                String make = row[2];
                String model = row[3];
                String vehicleType = row[4];
                String color = row[5];
                int odometer = Integer.parseInt(row[6]);
                double price = Double.parseDouble((row[7]));

                Vehicle vehicles = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
               vehicleList.add(vehicles);

            }
            bufferedReader.close();

        }
        catch(IOException ex){
            System.out.println("Failed to load csv file.");

        }
        return dealership;
    }












}
