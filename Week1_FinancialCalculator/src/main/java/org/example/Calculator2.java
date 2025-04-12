package org.example;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {

        System.out.println("What is your initial deposit?");

        Scanner scanner = new Scanner(System.in);

        double P = scanner.nextDouble();

        System.out.println("What is the annual interest rate?");

        double annInt = scanner.nextDouble();

        System.out.println("How many years will pass?");

        double t = scanner.nextDouble();

        double r = (annInt/100);

        double n = 365;

        double FV = P*Math.pow(1 + r/n,n * t);

        double totalInterest = FV - P;

        System.out.printf("Your future value of the deposit is $%.2f and your total interest earned is $%.2f",FV,totalInterest);




    }
}
