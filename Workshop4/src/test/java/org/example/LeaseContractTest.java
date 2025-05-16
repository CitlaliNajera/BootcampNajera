package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeaseContractTest {
    @Test
    public void determineLeaseContract() {
        Vehicle vehicleTest = new Vehicle(20456, 2005, "Toyota", "Camry", "Sedan", "Blue", 145000, 3500.00);
        LeaseContract testLeaseContract = new LeaseContract("5-15-2025", "Brain", "brain@email.com", vehicleTest, true);

        double totalResult = testLeaseContract.gettotalPrice();
        double monthlyResult = testLeaseContract.getmonthlyPayment();

        assertEquals(1995.00, totalResult);
        assertEquals(44.43, monthlyResult, .02);


    }

    @Test
    public void determineLeaseContract2() {
        Vehicle vehicleTest = new Vehicle(20456, 2005, "Toyota", "Camry", "Sedan", "Blue", 145000, 3500.00);
        LeaseContract testLeaseContract = new LeaseContract("5-15-2025", "Brain", "brain@email.com", vehicleTest, false);


        double monthlyResult = testLeaseContract.getmonthlyPayment();


        assertEquals(0.00, monthlyResult, .02);


    }
}







