package org.example;

import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {

        //user input: monthly payout, expected interest rate, number of years
        //calculate Present value

        System.out.println("What is the monthly payout for your annuity?");

        Scanner scanner = new Scanner(System.in);

        double PMT = scanner.nextDouble();

        System.out.println("What is the expected interest rate? ");

        double annInt = scanner.nextDouble();

        System.out.println("How many years will it be?");

        double t = scanner.nextDouble();

        double r = (annInt/12) / 100 ;

        double n = t * 12;

        double innerPiece = 1 - Math.pow(1+r,-n);

        double PV = PMT * (innerPiece /r) ;

        System.out.printf("You would need to invest $%.2f today",PV );




    }
}
