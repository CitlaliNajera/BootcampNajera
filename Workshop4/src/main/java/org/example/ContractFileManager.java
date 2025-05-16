package org.example;

import java.io.*;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractFileManager {

    private static final String FILE_PATH = "src/main/resources/contracts";

    public static void saveReceiptToFile(String receiptContent) {
        try {
            File file = new File(FILE_PATH);
            File parentDir = file.getParentFile();

            // Create parent directories if they don't exist
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Write to the file
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(receiptContent);
            bufferedWriter.newLine(); // Adds a line break after each entry
            bufferedWriter.close();

            System.out.println("Receipt successfully saved to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static String generateReceipt(Contract contract) {
        StringBuilder receipt = new StringBuilder();
        Vehicle vehicle = contract.getVehicle();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = LocalDate.now().format(dateFormatter);

        receipt.append("------------ RECEIPT ------------\n");
        receipt.append("Date: ").append(date).append("\n\n");
        receipt.append("Vehicle Information:\n");
        receipt.append(vehicle.toString()).append("\n\n");
        receipt.append("Contract Details\n");

        if (contract instanceof SalesContract) {
            SalesContract sale = (SalesContract) contract;
            receipt.append("Name: ").append(sale.getCustomerName());
            receipt.append("\n");
            receipt.append("Email address: ").append(sale.getCustomerEmail());
            receipt.append("\n");
            receipt.append("Contract Type: SALE\n");
            receipt.append("Total Price: $").append(String.format("%.2f", sale.gettotalPrice())).append("\n");
            if (sale.isFinanceLoan()) {
                receipt.append("Monthly Payment: $").append(String.format("%.2f", sale.getmonthlyPayment())).append("\n");
            } else {
                receipt.append("Paid in Full\n");
            }
        }
        else if (contract instanceof LeaseContract) {
            LeaseContract lease = (LeaseContract) contract;
            receipt.append("Name: ").append(lease.getCustomerName());
            receipt.append("\n");
            receipt.append("Email address: ").append(lease.getCustomerEmail());
            receipt.append("\n");
            receipt.append("Contract Type: LEASE\n");
            receipt.append("Total Price: $").append(String.format("%.2f", lease.gettotalPrice())).append("\n");
            receipt.append("Monthly Payment: $").append(String.format("%.2f", lease.getmonthlyPayment())).append("\n");
        }

        receipt.append("\n---------------------------------\n");
        return receipt.toString();
    }













}
