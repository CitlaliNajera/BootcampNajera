package org.example;

import java.time.LocalDate;
import java.time.LocalTime;


public class LedgerRepository {

    public static void addDeposit(String description, String vendor, double amount) {

        Transaction deposit = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount);

        TransactionFileManager.appendTransaction(deposit);

    }
    public static void makePayment(String description, String vendor, double amount) {

        Transaction payment = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                -(amount));

        TransactionFileManager.appendTransaction((payment));

    }





}
