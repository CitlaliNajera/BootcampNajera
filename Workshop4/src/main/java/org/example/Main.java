package org.example;



public class Main {
    private static DealershipFileManager FileManager;

    public static void main(String[] args) {

        Dealership dealership = FileManager.getDealership();

        if (dealership != null) {
            System.out.println("Dealership: " + dealership.getName());
            System.out.println("Address: " + dealership.getAddress());
            System.out.println("Phone: " + dealership.getPhone());

            System.out.println("\nInventory:");
            for (Vehicle vehicle : dealership.getInventory()) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("No dealership data found.");
        }

    }
}