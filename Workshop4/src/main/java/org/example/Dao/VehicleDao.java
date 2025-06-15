package org.example.Dao;

import org.example.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private final String connectionString;
    private final String userName;
    private final String password;

    public VehicleDao(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);) {

            stmt.setDouble(1, min);
            stmt.setDouble(2, max);


            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin"));
                    newVehicle.setVehicleType(rs.getString("Type"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getInt("odometer"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    vehicles.add(newVehicle);

                }

            }

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle>getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE make = ? AND model = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);) {

            stmt.setString(1, make);
            stmt.setString(2, model);


            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin"));
                    newVehicle.setVehicleType(rs.getString("Type"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getInt("odometer"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    vehicles.add(newVehicle);

                }

            }

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;

    }

    public List<Vehicle>getVehicleByYearRange(int startYear, int endYear){
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);) {

            stmt.setInt(1, startYear);
            stmt.setInt(2, endYear);


            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin"));
                    newVehicle.setVehicleType(rs.getString("Type"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getInt("odometer"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    vehicles.add(newVehicle);

                }

            }

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle>getVehiclesByColor(String color){
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE color = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);) {

            stmt.setString(1, color);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin"));
                    newVehicle.setVehicleType(rs.getString("Type"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getInt("odometer"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    vehicles.add(newVehicle);

                }
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;



    }

    public List<Vehicle>getVehiclesByMileage(double odometerLow, double odometerHigh){
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);) {

            stmt.setDouble(1, odometerLow);
            stmt.setDouble(2, odometerHigh);


            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin"));
                    newVehicle.setVehicleType(rs.getString("Type"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getInt("odometer"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    vehicles.add(newVehicle);

                }

            }

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;






    }

    public List<Vehicle>getVehiclesByType(String carType){
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE type = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);) {

            stmt.setString(1, carType);


            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin"));
                    newVehicle.setVehicleType(rs.getString("Type"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getInt("odometer"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    vehicles.add(newVehicle);

                }

            }

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;

    }

    public List<Vehicle>getAllVehicles(){
        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicles";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {


                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin"));
                    newVehicle.setVehicleType(rs.getString("Type"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getInt("odometer"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    vehicleList.add(newVehicle);

                }

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicleList;

    }

    public void addVehicle(Vehicle vehicle){
        String query = "INSERT INTO vehicles (Vin,Type,sold,price,year,color,odometer,make,model) VALUES (?,?,0,?,?,?,?,?,?)";

        try(Connection conn = DriverManager.getConnection(connectionString,userName,password);
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, vehicle.getVin());
            stmt.setString(2,vehicle.getVehicleType());
            stmt.setDouble(3,vehicle.getPrice());
            stmt.setInt(4,vehicle.getYear());
            stmt.setString(5,vehicle.getColor());
            stmt.setDouble(6,vehicle.getOdometer());
            stmt.setString(7, vehicle.getMake());
            stmt.setString(8, vehicle.getModel());

            stmt.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void removeVehicle(int vin){
        String query = "DELETE FROM vehicles WHERE Vin = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, vin);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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












}








