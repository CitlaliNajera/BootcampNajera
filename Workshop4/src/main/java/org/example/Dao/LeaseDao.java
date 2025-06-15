package org.example.Dao;

import org.example.LeaseContract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private final String connectionString;
    private final String userName;
    private final String password;

    public LeaseDao(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        String query = "INSERT INTO leasecontracts (Vin,CustomerName,LeaseTermMonths,MonthlyPayment,ContractDate,DealershipID,email) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, leaseContract.getVehicleVin());
            stmt.setString(2, leaseContract.getCustomerName());
            stmt.setInt(3,leaseContract.getLeaseTermMonths());
            stmt.setDouble(4, leaseContract.getMonthlyPayments());
            stmt.setString(5,leaseContract.getDate());
            stmt.setInt(6,leaseContract.getDealershipId());
            stmt.setString(7,leaseContract.getCustomerEmail());


            stmt.executeUpdate();
        }

        catch(SQLException ex){
            ex.printStackTrace();
        }
    }









}
