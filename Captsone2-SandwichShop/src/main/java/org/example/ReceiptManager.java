package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ReceiptManager {
    public static void saveReceipt(List<String> orders, double totalPrice) {

        // Create receipts directory if it doesn't exist
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Generate filename based on current date and time
        String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = LocalDate.now().format(dateFormatter);
        String fileName = "receipts/" + timeStamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("--- Sandwich Bar Receipt ---\n\n");
            int count = 1;
            for (String order : orders) {

                writer.write("Date: "+ date + "\n");
                writer.write("Order " + count++ + ":\n");
                writer.write(order + "\n\n");
            }
            writer.write(String.format("Total: $%.2f\n", totalPrice));
            writer.write("\nThank you for your order!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
