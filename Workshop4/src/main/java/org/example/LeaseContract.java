package org.example;

public class LeaseContract extends Contract {
    private boolean financeLoan;
    private int leaseTermMonths;
    private double monthlyPayments;
    private int dealershipId;
    private int vehicleVin;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financeLoan) {
        super(date, customerName, customerEmail, vehicle);
        this.financeLoan = financeLoan;
    }
    public LeaseContract(String date, String customerName, String customerEmail, int leaseTermMonths, double monthlyPayments, int dealershipId,int vehicleVin) {
        super(date, customerName, customerEmail);
       this.leaseTermMonths = leaseTermMonths;
       this.monthlyPayments = monthlyPayments;
       this.dealershipId = dealershipId;
       this.vehicleVin = vehicleVin;
    }

    public int getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(int vehicleVin) {
        this.vehicleVin = vehicleVin;
    }

    public int getLeaseTermMonths() {
        return leaseTermMonths;
    }

    public void setLeaseTermMonths(int leaseTermMonths) {
        this.leaseTermMonths = leaseTermMonths;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    public double getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(double monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
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
