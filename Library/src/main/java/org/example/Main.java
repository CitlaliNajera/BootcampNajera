package org.example;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Book [] inventory = new Book[20];

        inventory[0]= new Book(100,"9780323776714", "The Alchemist", true, "Mary Tomlinson");

        inventory[1]= new Book( 101,"9781234567890","Shadows of the Mind", true, "Alice Carter");

        inventory[2]= new Book(102,"9782345678901", "Echoes in the Wind", false);

        inventory[3] = new Book(103,"9783456789012","Beneath the Crimson",false);

        inventory[4]= new Book(104,"9784567890123","The Last Ember",true,"Daniel Rhodes");

        inventory[5]= new Book(105, "9785678901234", "Whispers of Tomorrow", false);

        inventory[6]= new Book(106,"9786789012345", "Tides of Fate", false);

        Scanner scanner = new Scanner(System.in);



        while(true){

            System.out.println("What do you want to do?");
            System.out.println("1) Show the books available");
            System.out.println("2) Show the books currently unavailable");
            System.out.println("3) Quit");

            int userChoice= scanner.nextInt();

            switch(userChoice){
                case 1:
                    System.out.println("\nAvailable Books:");
                    Book.displayBooksIn(inventory);

                    System.out.println("\nEnter the book ID to check out, or 0 to return to the home screen:");
                    int inputId = scanner.nextInt();
                    scanner.nextLine();
                    Book.findBookById(inventory, inputId, scanner);



                    if(inputId == 0){
                        System.out.println("Returning to home screen...");
                        break;

                    }
                break;

                case 2:
                    System.out.println("\n Unavailable books:");
                    Book.displayBooksOut(inventory);

                    System.out.println("\n Enter the book ID to check in a book, or 0 to return to the home screen");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    Book.findOutBookById(inventory,bookId ,scanner);


                    if (bookId ==0){
                        System.out.println("Returning to home screen...");
                        break;
                    }
                break;

                case 3:
                    System.out.println("Exiting the application, Goodbye!");
                    break;

                default:
                    System.out.println("Please select an option");
                    break;

            }
            if ( userChoice==3){
                break;
            }

        }


        }


    }
