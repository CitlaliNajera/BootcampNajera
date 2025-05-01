package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//this will be saving and loading into file
public class TransactionFileManager {

    public static void appendTransaction(Transaction transaction){
        String filePath= "src/main/resources/transactions.csv";
        File file = new File(filePath);

        try{
            File folder = file.getParentFile();
            if (!folder.exists()){
                folder.mkdirs();
            }

            boolean fileExists = file.exists();
            boolean isEmpty = !fileExists || file.length() ==0;

            FileWriter writer = new FileWriter(file, true);

            if(isEmpty){
                writer.write("date|time|description|vendor|amount\n");
            }

            writer.write(transaction.toCSV()+"\n");

            writer.close();


        } catch (IOException e){
            System.out.println("Error occurred while saving transaction");
            e.printStackTrace();
        }


    }
    public static List<Transaction> readFile(){
        try{
            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String input;

            List<Transaction> transactionList = new ArrayList<>();

            while((input = bufferedReader.readLine()) != null){
                String[] row = input.split("\\|");


                LocalDate date = LocalDate.parse(row[0]);
                LocalTime time = LocalTime.parse(row[1]);
                String description = row[2];
                String vendor = row[3];
                double amount = Double.parseDouble((row[4]));

                Transaction transactions = new Transaction(date,time,description,vendor,amount);
                transactionList.add(transactions);

            }
            bufferedReader.close();

            return transactionList;
        }
        catch(IOException ex){
            System.out.println("Failed to load csv file.");
            return new ArrayList<>();
        }
    }


}
