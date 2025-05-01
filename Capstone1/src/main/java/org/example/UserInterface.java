package org.example;


import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {

    public static Scanner scanner = new Scanner(System.in);


    static void displayMainMenu() {
        while (true) {
            System.out.println("""
                    Welcome to "The Accounting Ledger"
                    1)Add Deposit
                    2)Make Payment
                    3)Ledger menu
                    0)Exit
                    
                    """);
            try {
                int userInput = Integer.parseInt(scanner.nextLine());


                switch (userInput) {
                    case 1:
                        System.out.println("Adding deposit...");
                        System.out.println("Please fill in the information for deposit: ");
                        System.out.println("Enter description of transaction\n");
                        String userDescription = scanner.nextLine();
                        System.out.println("Enter vendor information\n");
                        String userVendor = scanner.nextLine();
                        System.out.println("Enter deposit amount\n");
                        double userDeposit = Double.parseDouble(scanner.nextLine());
                        LedgerRepository.addDeposit(userDescription, userVendor, userDeposit);
                        System.out.println("Deposit recorded successfully\n");
                        break;

                    case 2:
                        System.out.println("Payment processing...");
                        System.out.println("Please fill in information for payment: ");
                        System.out.println("Enter description of transaction\n");
                        String payDescription = scanner.nextLine();
                        System.out.println("Enter vendor information\n");
                        String payVendor = scanner.nextLine();
                        System.out.println("Enter payment amount\n");
                        double userPayment = Double.parseDouble(scanner.nextLine());
                        LedgerRepository.makePayment(payDescription, payVendor, userPayment);
                        System.out.println("Payment recorded successfully\n");
                        break;

                    case 3:
                        System.out.println("Loading Ledger menu...");
                        boolean inLedgerMenu=true;

                        while (inLedgerMenu) {
                            System.out.println("""
                                    Please select an entry to view results:
                                    1)All entries
                                    2)All deposits
                                    3)All payments
                                    4)Reports screen
                                    5)Home 
                                    
                                    """);
                            int ledgerInput = Integer.parseInt(scanner.nextLine());
                            switch (ledgerInput) {
                                case 1:
                                    Ledger.displayEntries();
                                    break;
                                case 2:
                                    Ledger.displayDeposits();
                                    break;
                                case 3:
                                    Ledger.displayPayments();
                                    break;
                                case 4:
                                    System.out.println("Loading Reports menu...");
                                    //learned how to manage many menus in switch case and use a boolean to exit

                                    boolean inReportsMenu=true;
                                    while (inReportsMenu) {
                                        System.out.println("""
                                                Please select an entry to search reports by:
                                                1)Search by Vendor
                                                2)Search by Description
                                                3)Previous Month
                                                4)Previous Year
                                                5)Search by custom date
                                                6)Back
                                                
                                                
                                                """);
                                        int reportInput = Integer.parseInt(scanner.nextLine());
                                        switch (reportInput) {
                                            case 1:
                                                System.out.println("Enter the vendor's name:\n");
                                                String vendorName =
                                                        scanner.nextLine().toUpperCase();
                                                System.out.println("Here are some entries:\n");
                                                Ledger.searchByVendor(vendorName, scanner);
                                                break;
                                            case 2:
                                                System.out.println("Enter the description under the transaction wanted:\n");
                                                String descriptionWords = scanner.nextLine().toUpperCase();
                                                System.out.println("Here are some entries:\n");
                                                Ledger.searchByDescription(descriptionWords,scanner);
                                                break;

                                            case 3:
                                                System.out.println("Here are your transactions from last month:\n");
                                                Ledger.getTransactionsFromLastMonth();
                                                break;
                                            case 4:
                                                System.out.println("Here are your transactions from last year: \n");
                                                Ledger.getTransactionsFromLastYear();
                                                break;
                                            case 5:
                                                System.out.println("Please enter start date in this format (YYYY-MM-DD):\n");
                                                String startInput = scanner.nextLine();
                                                LocalDate startDate = LocalDate.parse(startInput);

                                                System.out.println("Please enter end date in this format (YYYY-MM-DD):\n");
                                                String endInput = scanner.nextLine();
                                                LocalDate endDate = LocalDate.parse(endInput);

                                                System.out.println("Transactions found between chosen dates:\n");
                                                Ledger.getTransactionsBetween(startDate,endDate);
                                                break;
                                            case 6:
                                                System.out.println("Returning to Ledger menu...\n");
                                                inReportsMenu = false;
                                                break;
                                            default:
                                                System.out.println("\nPlease select an option");
                                                break;


                                        }
                                    }
                                break;

                                case 5:
                                    System.out.println("Returning to Home menu...\n");
                                    inLedgerMenu=false;
                                    break;

                                default:
                                    System.out.println("\nPlease select an option");
                                    break;
                            }
                        }
                        break;
                    case 0:
                        System.out.println("\nExiting the application, Goodbye!");
                        break;

                    default:
                        System.out.println("\nPlease select an option");
                        break;

                }
                if(userInput==0){
                    break;
                }

            } catch (Exception e) {
                System.out.println("Invalid input, please try again");
            }
        }

    }
}
