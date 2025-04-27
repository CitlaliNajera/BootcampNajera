package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> allProducts = FileLoader.readFile();
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("""
                    Welcome to "The Store"
                    Please enter an option below:
                    1)Display all products on sale
                    2)Search by SKU
                    3)Search by price range
                    4)Search by name
                    5)Add to Cart
                    6)Remove from cart
                    7)Display cart
                    8)Checkout
                    9)Exit the application 
                    """);
            int userInput = Integer.parseInt(scanner.nextLine());


            switch (userInput) {
                case 1:
                    System.out.println("Loading products available:");
                    displayProducts(allProducts);
                    break;

                case 2:
                    System.out.println("\n Enter the product SKU: ");
                    String skuInput = scanner.nextLine();
                    List<Product> match = findBySku(allProducts, skuInput, scanner);
                    if (match.isEmpty()) {
                        System.out.println("No product found with SKU");
                    } else {
                        System.out.println("Found products:");
                        for (Product p : match) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n Set a minimum and maximum price range");
                    System.out.println("\n Enter a minimum:");
                    double userMin = Double.parseDouble(scanner.nextLine());
                    System.out.println("\n Enter a maximum:");
                    double userMax = Double.parseDouble(scanner.nextLine());

                    List<Product> matches = findByPriceRange(allProducts, userMin, userMax, scanner);
                    if (matches.isEmpty()) {
                        System.out.println("No products found in that price range");
                    } else {
                        System.out.println("Found products:");
                        for (Product p : matches) {
                            System.out.println(p);

                        }
                    }
                    break;

                case 4:
                    System.out.println("\n Enter the product name: ");
                    String nameInput = scanner.nextLine();
                    List<Product> matched = searchByName(allProducts, nameInput, scanner);

                    if (matched.isEmpty()) {
                        System.out.println("No products found ");
                    } else {
                        System.out.println("Found products: ");
                        for (Product p : matched) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Please input the SKU of the product being added to cart: ");
                    String skuProduct = scanner.nextLine();
                    List<Product> found = findBySku(allProducts, skuProduct, scanner);

                    if (found.isEmpty()) {
                        System.out.println("No product found with that SKU.");
                    } else {
                        System.out.println("Found products:");
                        for (int i = 0; i < found.size(); i++) {
                            System.out.println((i + 1) + ". " + found.get(i));
                        }

                        System.out.println("Enter the number of the product you want to add to your cart:");
                        int choice = Integer.parseInt(scanner.nextLine());

                        if (choice > 0 && choice <= found.size()) {
                            Product selectedProduct = found.get(choice - 1);
                            cart.addProductToCart(selectedProduct);
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Please input the SKU of the product being removed from cart: ");
                    String skuRemove = scanner.nextLine();
                    List<Product> productRemove = findBySku(allProducts, skuRemove, scanner);
                    if (productRemove.isEmpty()) {
                        System.out.println("No product found with that SKU.");
                    } else {
                        System.out.println("Found products:");
                        for (int i = 0; i < productRemove.size(); i++) {
                            System.out.println((i + 1) + ". " + productRemove.get(i));
                        }

                        System.out.println("Enter the number of the product you want to remove from your cart:");
                        int choice = Integer.parseInt(scanner.nextLine());

                        if (choice > 0 && choice <= productRemove.size()) {
                            Product selectedProduct = productRemove.get(choice - 1);
                            cart.removeProduct(selectedProduct);
                        } else {
                            System.out.println("Invalid choice.");
                        }


                    }
                case 7:
                    cart.displayItems();
                    break;

                case 8:
                    System.out.println("\n Thank you for shopping with us!");
                    cart.displayItems();
                    cart.getCartTotal();
                    displayOrderDate();
                    cart.clearCart();
                    System.out.println("Your cart is now clear\n");
                    break;

                case 9:
                    System.out.println("\nExiting the application, Goodbye!");
                    break;

                default:
                    System.out.println("\nPlease select an option");
                    break;
            }
            if (userInput == 9) {
                break;
            }
        }

        }

        public static void displayProducts (List < Product > products) {

            for (Product selectProduct : products) {

                if (selectProduct != null) {
                    System.out.println(selectProduct.getProductName() + " - $" + selectProduct.getPrice());
                    System.out.println("   Department: " + selectProduct.getDepartment() + " | SKU: " + selectProduct.getSku());
                }
            }

        }

        public static List<Product> findBySku (List < Product > products, String sku, Scanner scanner){
            List<Product> skuProducts = new ArrayList<>();

            for (Product selectProduct : products) {
                if (selectProduct.getSku().contains(sku)) {
                    skuProducts.add(selectProduct);

                }
            }
            return skuProducts;


        }

        public static List<Product> findByPriceRange (List < Product > products,double min, double max, Scanner scanner)
        {
            List<Product> matchedProducts = new ArrayList<>();

            for (Product selectProduct : products) {
                if (selectProduct.getPrice() > min && selectProduct.getPrice() < max) {
                    matchedProducts.add(selectProduct);

                }
            }
            return matchedProducts;

        }

        public static List<Product> searchByName (List < Product > products, String productName, Scanner scanner){
            List<Product> matched = new ArrayList<>();

            for (Product selectProduct : products) {
                if (selectProduct.getProductName().contains(productName)) {
                    matched.add(selectProduct);
                }
            }
            return matched;

        }

        public static void displayOrderDate () {
            LocalDateTime now = LocalDateTime.now(); // gets the current date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"); //formatting
            String formattedDate = now.format(formatter);

            System.out.println("\nOrder Date and Time: " + formattedDate);
        }


    }
