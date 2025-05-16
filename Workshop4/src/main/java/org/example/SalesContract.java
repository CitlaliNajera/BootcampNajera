package org.example;

public class SalesContract extends Contract {
    private boolean financeLoan;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financeLoan) {
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
        int processingFee = 0;
        final double salesTax= 0.05 * getVehicle().getPrice();
        final double vehicleAmount = getVehicle().getPrice();

        if (getVehicle().getPrice()<10000){
            processingFee=295;

        }
        else if(getVehicle().getPrice()>=10000){
            processingFee=495;
        }

        return 100 + processingFee + salesTax + vehicleAmount;
    }
    @Override
    public double getmonthlyPayment(){
        if (!financeLoan) {
            return 0.0;
        }
        double interestRate;
        int loanTerm;

        if (gettotalPrice() < 10000) {
            interestRate = 5.25 / 100;
            loanTerm = 24;
        } else {
            interestRate = 4.25 / 100;
            loanTerm = 48;
        }

        double monthlyRate = interestRate / 12;

        return (gettotalPrice() * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -loanTerm));
    }



        }


