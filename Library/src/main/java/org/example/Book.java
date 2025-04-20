package org.example;

import java.util.Scanner;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "Empty";


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkedOutTo='" + checkedOutTo + '\'' +
                '}';
    }

    public static void displayBooksIn(Book[] inventory) {
        for (int i = 0; i < inventory.length; i++) {

            if (inventory[i] != null && !inventory[i].isCheckedOut) {
                System.out.println(inventory[i].toString());
            }

        }


    }

    public static void findBookById(Book[] inventory, int id, Scanner scanner) {

        for (int i = 0; i < inventory.length; i++) {

            Book currentBook = inventory[i];

            if (currentBook != null && currentBook.id == id) {
                currentBook.isCheckedOut = true;
                System.out.println("To finish checking out, please enter your name");
                String userName = scanner.nextLine();
                currentBook.checkedOutTo = userName;
                System.out.println("Congrats the book is yours!");
                System.out.println("Returning to home screen...");

                break;

            }
        }

    }

    public static void displayBooksOut(Book[] inventory) {
        for (int i = 0; i < inventory.length; i++) {

            if (inventory[i] != null && inventory[i].isCheckedOut) {
                System.out.println(inventory[i].toString());
            }
        }
    }

    public static void findOutBookById(Book[] inventory, int id, Scanner scanner) {

        for (int i = 0; i < inventory.length; i++) {

            Book selectedBook = inventory[i];

            if (selectedBook != null && selectedBook.id == id) {
                selectedBook.isCheckedOut = false;
                selectedBook.checkedOutTo = "N/A";
                System.out.println("Your book has been checked back in... \n Returning to home screen. ");
                break;

            }

        }

    }

    public static void findBooksByTitle(Book[] inventory, String title, Scanner scanner) {
        boolean found =false;
        for (int i = 0; i < inventory.length; i++) {

            Book bookFound = inventory[i];

            if (bookFound != null && bookFound.title.trim().equalsIgnoreCase(title.trim())) {
                System.out.println("Here is the book information: " + bookFound.toString() +"\n " +
                        "Returning to the home screen...");
                found=true;
                break;



            }
        }
        if (!found) {
            System.out.println("System does not recognize that Title. Please try again.");
        }

    }

    public static void findBookByIsbn(Book[] inventory, String isbn, Scanner scanner) {
        boolean found = false;

        for (int i = 0; i < inventory.length; i++) {


            Book bookIsbn = inventory[i];

            if (bookIsbn != null && bookIsbn.isbn.trim().equalsIgnoreCase(isbn.trim())) {
                System.out.println("Here is the books information: " + bookIsbn.toString()+
                        "\n Returning to the home screen...");
                found = true;
                break;

            }

        }
        if(!found){
            System.out.println("System does not recognize that ISBN. Please try again.");
        }


    }
}