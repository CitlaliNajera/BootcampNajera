package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("What is your total amount of the loan?");

        Scanner scanner = new Scanner(System.in);

        double P = scanner.nextDouble();

        System.out.println("What is your interest rate?");

        double annualR = scanner.nextDouble();

        System.out.println("What is the length of the loan in years?");

        double y = scanner.nextDouble();

        double r = (annualR /12) / 100;
//equation for monthly interest rate
        double n = y * 12;
//equation for # of monthly payments
        double piece = (1 + r);

        double pieceTwo = Math.pow(piece,n);

        double pieceThree = pieceTwo * r;

        double left = pieceThree * P;

        double right = pieceTwo - 1;

        double M = left / right ;

        double totalInterest = (M * n) - P;

        System.out.printf("Your monthly payment is $%.2f and your total interest $%.2f ",M,totalInterest);
















    }
}