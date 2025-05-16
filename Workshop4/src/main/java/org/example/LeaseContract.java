package org.example;

public class LeaseContract extends Contract {
    private boolean financeLoan;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financeLoan) {
        super(date, customerName, customerEmail, vehicle);
        this.financeLoan = financeLoan;
    }

    public boolean isFinanceLoan() {
        return financeLoan;
    }

    public void setFinanceLoan(boolean financeLoan) {
        this.financeLoan = financeLoan;
    }

    @Override
    public double gettotalPrice(){
   double vehiclePrice =getVehicle().getPrice();
   double leaseFee = 0.07 * vehiclePrice;
   double expectedEndingValue = 0.50 * vehiclePrice;

   return leaseFee + expectedEndingValue;
    }

    @Override
    public double getmonthlyPayment(){
        if (!financeLoan) {
            return 0.00;
        }
        int leaseTerm = 36;
        double interestRate = 0.04 / 12;
        double vehiclePrice = getVehicle().getPrice();

        double amountFinanced = vehiclePrice - gettotalPrice();

        return (amountFinanced * interestRate) / (1 - Math.pow(1 + interestRate, -leaseTerm));


    }


}
