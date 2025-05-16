package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalesContractTest {
    @Test
    public void determineSalesContract() {
        Vehicle vehicleTest = new Vehicle(20456, 2005, "Toyota", "Camry", "Sedan", "Blue", 145000, 3500.00);
        SalesContract testSalesContract = new SalesContract("5-15-2025", "Brain", "brain@email.com", vehicleTest, true);


        double totalResult = testSalesContract.gettotalPrice();

        double monthlyResult = testSalesContract.getmonthlyPayment();


          //delta used to specify the margin of error that's acceptable

        assertEquals(4070, totalResult);
        assertEquals(179.01, monthlyResult, .02);


    }

    @Test
    public void determineSalesContract2() {
        Vehicle vehicleTest = new Vehicle(98763, 2018, "Nissan", "Altima", "Sedan", "White", 64000, 11000.00);
        SalesContract testSalesContract = new SalesContract("5-15-2025", "Brain", "brain@email.com", vehicleTest, true);


        double totalResult = testSalesContract.gettotalPrice();

        double monthlyResult = testSalesContract.getmonthlyPayment();

        assertEquals(12145, totalResult);
        assertEquals(275.58, monthlyResult, .02);


    }

    @Test
    public void determineSalesContract3() {
        Vehicle vehicleTest = new Vehicle(98763, 2018, "Nissan", "Altima", "Sedan", "White", 64000, 11000.00);
        SalesContract testSalesContract = new SalesContract("5-15-2025", "Brain", "brain@email.com", vehicleTest, false);


        double monthlyResult = testSalesContract.getmonthlyPayment();


        assertEquals(00.00, monthlyResult, .02);


    }
}
