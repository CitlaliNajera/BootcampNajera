package org.example.Dao;
import org.example.SalesContract;

import java.sql.*;

public class SalesDao {

        private final String connectionString;
        private final String userName;
        private final String password;

        public SalesDao(String connectionString, String userName, String password) {
            this.connectionString = connectionString;
            this.userName = userName;
            this.password = password;
        }

    public void addSalesContract(SalesContract salesContract) {
        String query = "INSERT INTO salescontact (Vin,CustomerName,SalePrice,ContractDate,DealershipID,email) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, salesContract.getVehicleVin());
            stmt.setString(2, salesContract.getCustomerName());
            stmt.setDouble(3,salesContract.getSalePrice());
            stmt.setString(4,salesContract.getDate());
            stmt.setInt(5,salesContract.getDealershipId());
            stmt.setString(6,salesContract.getCustomerEmail());


            stmt.executeUpdate();
        }

        catch(SQLException ex){
            ex.printStackTrace();
        }
    }








}
