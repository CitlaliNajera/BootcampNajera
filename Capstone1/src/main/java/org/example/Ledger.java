package org.example;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Scanner;


public class Ledger {

    private static TransactionFileManager FileLoader;
    private static List<Transaction> allTransactions = FileLoader.readFile();


//learned about sort and how its used in lambdas
    public static void displayEntries() {

        if (allTransactions.isEmpty()) {
            System.out.println("Your ledger is empty");
        } else {
           allTransactions.sort((t1,t2) -> {

               //compare dates
               int dateCompare = t2.getDate().compareTo(t1.getDate());

               //if date is the same, it will compare times

               if(dateCompare==0){
                   return t2.getTime().compareTo(t1.getTime());

               }else{
                   return dateCompare;
               }
            });
            System.out.println("Your recent entries:\n");
            for(Transaction t: allTransactions){
                System.out.println(t);
            }
        }
    }

    public static void displayDeposits() {
        boolean found = false;
        System.out.println("Here are your deposits:\n");


        for (Transaction t : allTransactions) {
            if (t.getAmount() > 0) {
                System.out.println(t.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No deposit transactions found.");
        }
    }

    public static void displayPayments(){
        boolean found=false;
        System.out.println("Here are your payments: \n");

        for(Transaction tr : allTransactions){
            if(tr.getAmount() < 0){
                System.out.println(tr.toString());
                found = true;
            }
        }
        if(!found){
            System.out.println("No payment transactions found.");
        }

    }

    public static void  searchByVendor(String vendorName, Scanner scanner){
        boolean found =false;

        for(Transaction selectTransactions : allTransactions){
            if(selectTransactions.getVendor().toUpperCase().contains(vendorName)){

                System.out.println(selectTransactions.toString());
                found=true;

            }
        }
        if(!found){
            System.out.println("System could not find vendor, please try again");
        }

    }

    public static void getTransactionsFromLastMonth(){
        boolean found= false;
        LocalDate today = LocalDate.now();
        YearMonth lastMonth = YearMonth.from(today).minusMonths(1);

        for(Transaction d : allTransactions){
            YearMonth transactionMonth = YearMonth.from(d.getDate());
            if(transactionMonth.equals(lastMonth)){
                System.out.println(d.toString());
                found=true;
            }
        }
        if(!found){
            System.out.println("System could not find entries for last month");
        }
    }

    public static void getTransactionsFromLastYear(){
        boolean found= false;
        int lastYear = LocalDate.now().getYear()-1;

        for(Transaction y : allTransactions){
            if(y.getDate().getYear()==lastYear){
                System.out.println(y.toString());
                found=true;
            }
        }
        if(!found){
            System.out.println("System could not find entries for last year");
        }
    }

    public static void getTransactionsBetween(LocalDate startDate, LocalDate endDate){
        boolean found = false;

        for(Transaction d : allTransactions){
            LocalDate date = d.getDate();
            if((date.isEqual(startDate)||date.isAfter(startDate))&&
                    (date.isEqual(endDate)||date.isBefore(endDate)))

                System.out.println(d.toString());
                found =true;
            }

        if(!found){
            System.out.println("System could not find dates, please try again");
        }
    }
    public static void  searchByDescription(String description, Scanner scanner){
        boolean found = false;

        for(Transaction selectTransactions : allTransactions){
            if(selectTransactions.getDescription().toUpperCase().contains(description)){

                System.out.println(selectTransactions.toString());
                found=true;

            }
            if(!found){
                System.out.println("System could not find description, please try again");
            }
        }

    }

}













