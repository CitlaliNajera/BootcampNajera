package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart(){
        this.products= new ArrayList<>();
    }




//TODO: add product to cart method
    public void addProductToCart(Product product){

        if(products != null){
            products.add(product);
            System.out.println("Added to cart: "+ product);
        }else{
            System.out.println("System error: product inventory null");
        }

    }

    //TODO remove product from cart method
    //You will need the SKU of the product you want to remove
    //Loop through the list of products
    //Check to see if the SKU matches
    //Get that Product, then use the remove method AFTER the loop
    public void removeProduct( Product product){
        if(products != null){
            products.remove(product);
            System.out.println("Removed from cart: " +product);
        }else{
            System.out.println("System error: product inventory null");
        }
    }


    public void displayItems() {
        if (products.isEmpty()) {
            System.out.println("\n Your shopping cart is empty");
        } else {
            System.out.println("\nItems in your shopping cart:");
            for (Product product : products) {
                System.out.println("\nSKU: " + product.getSku() +
                        "\nName: " + product.getProductName() +
                        "\nPrice: $" + product.getPrice() +
                        "\nDepartment: " + product.getDepartment());
            }

        }
    }

    //TODO cart total method
    public double getCartTotal(){
        double total = 0.0;

        if(products.isEmpty()){
            System.out.println("\n Your cart is empty ");
        }else{
            System.out.println("\n Calculating your total: ");
            for(Product product : products){
                System.out.println("\n Price: $"+product.getPrice());
                total += product.getPrice();
            }
            System.out.printf("\nTotal Amount: $%.2f\n",total);
        }
        return total;
    }

    public void clearCart() {
        products.clear();
    }





}
