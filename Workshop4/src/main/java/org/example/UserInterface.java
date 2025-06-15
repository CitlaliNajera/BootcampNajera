package org.example;
import org.example.Dao.LeaseDao;
import org.example.Dao.SalesDao;
import org.example.Dao.VehicleDao;

import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.*;

public class UserInterface {
    private static Dealership dealership;

    public static void display(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter database username: ");
        String dbUserName = scanner.nextLine();
        System.out.print("Enter database password: ");
        String dbPassword = scanner.nextLine();

        String connectionString = "jdbc:mysql://localhost:3306/dealership";
        VehicleDao vehicleDao = new VehicleDao(connectionString, dbUserName, dbPassword);
        SalesDao salesDao = new SalesDao(connectionString,dbUserName,dbPassword);
        LeaseDao leaseDao = new LeaseDao(connectionString,dbUserName,dbPassword);



        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    Welcome to AutoMart Dealership\n 
                    1)Find vehicles within a price range
                    2)Find vehicle by make & model
                    3)Find vehicles by year range
                    4)Find vehicles by color
                    5)Find vehicles by mileage range
                    6)Find vehicles by type
                    7)List all vehicles 
                    8)Add a vehicle 
                    9)Remove a vehicle
                    10)Contract menu
                    99)Close menu 
                    
                    
                    """);
            try {
                int userInput = Integer.parseInt(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        System.out.println("Please fill out information below: \n");
                        sleep(500);
                        System.out.println("Minimum price: \n");
                        double minPrice = Double.parseDouble(scanner.nextLine());
                        sleep(500);
                        System.out.println("Maximum price:\n");
                        double maxPrice = Double.parseDouble(scanner.nextLine());
                        sleep(500);
                        List<Vehicle> vehicles = vehicleDao.getVehiclesByPrice(minPrice, maxPrice);

                        if (vehicles.isEmpty()) {
                            System.out.println("No vehicles found in the specified price range.\n");
                        } else {
                            vehicleDao.displayVehicles(vehicles);
                        }
                        break;
                    case 2:
                        System.out.println("Please fill out information\n");
                        sleep(500);
                        System.out.println("Make of car:\n");
                        String carMake = scanner.nextLine();
                        sleep(500);
                        System.out.println("Model of car:\n");
                        String carModel = scanner.nextLine();
                        sleep(500);
                        List<Vehicle> vehicles1 = vehicleDao.getVehiclesByMakeModel(carMake, carModel);
                        if (vehicles1.isEmpty()) {
                          System.out.println("No vehicles found with that make or model.\n");
                         } else {
                          vehicleDao.displayVehicles(vehicles1);
                        }
                        break;
                    case 3:
                        System.out.println("Please fill out information:\n");
                        sleep(500);
                        System.out.println("Starting year: \n");
                        int yearStart = Integer.parseInt(scanner.nextLine());
                        sleep(500);
                        System.out.println("Ending year: \n");
                        int yearEnd = Integer.parseInt(scanner.nextLine());
                        sleep(500);
                        List<Vehicle> vehicles2 = vehicleDao.getVehicleByYearRange(yearStart, yearEnd);
                        if (vehicles2.isEmpty()) {
                            System.out.println("No vehicles found in between the years chosen.\n");
                        } else {
                            vehicleDao.displayVehicles(vehicles2);
                        }
                        break;
                    case 4:
                        System.out.println("Please fill out information: \n");
                        sleep(500);
                        System.out.println("Enter a color: \n");
                        String color = scanner.nextLine();
                        sleep(500);
                        List<Vehicle> vehicles3 = vehicleDao.getVehiclesByColor(color);
                        if (vehicles3.isEmpty()) {
                            System.out.println("No vehicles found in the color chosen.\n");
                        } else {
                            vehicleDao.displayVehicles(vehicles3);
                        }
                        break;
                    case 5:
                        System.out.println("Please fill out information: \n");
                        sleep(500);
                        System.out.println("Odometer minimum: \n");
                        int odometerLow = Integer.parseInt(scanner.nextLine());
                        sleep(500);
                        System.out.println("Odometer maximum: \n");
                        int odometerHigh = Integer.parseInt(scanner.nextLine());

                        List<Vehicle> vehicles4 = vehicleDao.getVehiclesByMileage(odometerLow, odometerHigh);
                        if (vehicles4.isEmpty()) {
                            System.out.println("No vehicles found between the odometer range entered.\n");
                        } else {
                            vehicleDao.displayVehicles(vehicles4);
                        }
                        break;
                    case 6:
                        System.out.println("Please fill out information: \n");

                        System.out.println("Enter type of vehicle: \n");
                        String carType = scanner.nextLine();

                        List<Vehicle> vehicles5 = vehicleDao.getVehiclesByType(carType);
                        if (vehicles5.isEmpty()) {
                            System.out.println("No vehicles found with the specific car type chosen.\n");
                        } else {
                            vehicleDao.displayVehicles(vehicles5);
                        }
                        break;

                    case 7:
                        System.out.println("Listing all vehicles... \n");
                        sleep(500);
                        List<Vehicle> vehicles6 = vehicleDao.getAllVehicles();
                        vehicleDao.displayVehicles(vehicles6);
                        break;

                    case 8:
                        System.out.println("Please fill out information to add vehicle\n");

                        System.out.println("Enter VIN: \n");
                        int vin = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter Year: \n");
                        int year = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter Make:\n ");
                        String make = scanner.nextLine();

                        System.out.println("Enter Model: \n");
                        String model = scanner.nextLine();

                        System.out.println("Enter Type (e.g., Sedan, SUV, Truck): \n");
                        String type = scanner.nextLine();

                        System.out.println("Enter Color:\n ");
                        String carColor = scanner.nextLine();

                        System.out.println("Enter Odometer Reading: \n");
                        int odometer = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter Price:\n ");
                        double price = Double.parseDouble(scanner.nextLine());

                        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, carColor, odometer, price);
                        vehicleDao.addVehicle(newVehicle);

                        System.out.println("Vehicle added successfully: \n" + newVehicle);
                        break;

                    case 9:
                        System.out.println("Enter the VIN of the vehicle to remove:\n ");
                        sleep(500);
                        int vinRemove = Integer.parseInt(scanner.nextLine());

                            vehicleDao.removeVehicle(vinRemove);
                            System.out.println("Vehicle removed successfully \n");

                        break;
                    case 10:
                        System.out.println("Loading Contract menu...\n");
                        sleep(500);
                        boolean inContractMenu =true;

                        while(inContractMenu){
                            System.out.println("""
                                    Please select the contract you would like to fill out: 
                                    1) Sales Contract
                                    2) Lease Contract 
                                    3) Return to main menu
                                  
                                    
                                    """);
                            int contractInput = Integer.parseInt(scanner.nextLine());
                            switch(contractInput){
                                case 1:

                                    System.out.println("Set date in this format yyyy-mm-dd \n ");
                                    String date = scanner.nextLine();
                                    sleep(500);


                                    System.out.println("Enter customer name: \n");
                                    String customerName = scanner.nextLine();
                                    sleep(500);

                                    System.out.println("Enter customer email:\n ");
                                    String customerEmail = scanner.nextLine();
                                    sleep(500);

                                    System.out.println("Enter the VIN of the vehicle you want to create a sales contract for:\n");
                                    int salesVin = Integer.parseInt(scanner.nextLine());
                                    sleep(500);

                                    System.out.println("Enter the dealership ID for this vehicle:");
                                    int dealershipId = Integer.parseInt(scanner.nextLine());
                                    sleep(500);

                                    System.out.println("Enter the sale price of the vehicle:");
                                    double salePrice= Double.parseDouble(scanner.nextLine());
                                    sleep(500);


                                   // System.out.println("Will this be financed? (yes/no)\n");
                                    //String financeInput = scanner.nextLine();
                                    //boolean financeLoan = financeInput.equalsIgnoreCase("yes");

                                    SalesContract salesContract = new SalesContract(
                                            date,
                                            customerName,
                                            customerEmail,
                                            salesVin,
                                            dealershipId,
                                            salePrice
                                    );

                                    //ContractDataManager.processContract(dealership, salesContract);
                                    //String receipt = ContractFileManager.generateReceipt(salesContract);
                                   // System.out.println(receipt);
                                   // ContractFileManager.saveReceiptToFile(receipt);

                                    salesDao.addSalesContract(salesContract);
                                    System.out.println("Sales contract added");

                                    break;

                                case 2:
                                    //DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                                    //String leaseDate = LocalDate.now().format(dateFormatter2);
                                   // System.out.println("Today's date: \n" +leaseDate +"\n ");
                                    System.out.println("Set date in this format yyyy-mm-dd \n ");
                                    String leaseDate = scanner.nextLine();
                                    sleep(500);


                                    System.out.println("Enter customer name:\n ");
                                    String leaseName = scanner.nextLine();
                                    sleep(500);

                                    System.out.println("Enter customer email: \n");
                                    String leaseEmail = scanner.nextLine();
                                    sleep(500);

                                    System.out.println("Enter the VIN of the vehicle you want to create a sales contract for:\n");
                                    int leaseVin = Integer.parseInt(scanner.nextLine());
                                    sleep(500);

                                    System.out.println("Enter customer lease term in amount of months: \n");
                                    int leaseTermMonths = Integer.parseInt(scanner.nextLine());
                                    sleep(500);

                                    System.out.println("Enter monthly payments amount: \n");
                                    double monthlyPayment = Double.parseDouble(scanner.nextLine());
                                    sleep(500);

                                    System.out.println("Enter DealershipID: \n");
                                    int leaseDealershipId = Integer.parseInt(scanner.nextLine());
                                    sleep(500);

                                   // Vehicle leaseVehicle = dealership.getVehicleByVIN(leaseVin);

                                    //if (leaseVehicle == null) {
                                   //     System.out.println("No vehicle found with VIN\n");
                                   // } else {
                                     //   System.out.println("Vehicle selected: \n" + leaseVehicle);
                                   // }

                                   // System.out.println("Will this be financed? (yes/no)\n");
                                   // String loanInput = scanner.nextLine();
                                   // boolean financeLease = loanInput.equalsIgnoreCase("yes");

                                    LeaseContract leaseContract = new LeaseContract(
                                            leaseDate,
                                            leaseName,
                                            leaseEmail,
                                            leaseTermMonths,
                                            monthlyPayment,
                                            leaseDealershipId,
                                            leaseVin

                                    );

                                    leaseDao.addLeaseContract(leaseContract);
                                    System.out.println("Lease contract added");

                                   // ContractDataManager.processContract(dealership, leaseContract);
                                  //  String receiptLease = ContractFileManager.generateReceipt(leaseContract);
                                   // System.out.println(receiptLease);
                                   // ContractFileManager.saveReceiptToFile(receiptLease);

                                    break;

                                case 3:
                                    System.out.println("Returning...");
                                    inContractMenu = false;
                                    break;

                                default:
                                    System.out.println("\nPlease select an option");
                                    break;

                            }



                        }

                     break;
                    case 99:
                       // DealershipFileManager.saveDealership(dealership);
                        System.out.println("Exiting...");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Invalid option. Please select a valid menu item.");

                }
                if(userInput==99){
                    break;
                }

                }
            catch(Exception e){
                System.out.println("Invalid input, please try again");
                e.printStackTrace();


            }


        }

    }
}


