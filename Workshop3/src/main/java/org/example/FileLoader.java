package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<Product> readFile() {
        try {
            FileReader filereader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(filereader);

            //skip the first line
            bufferedReader.readLine();

            String input;
            //giving back an array of strings after splitting

            List<Product> productList = new ArrayList<>();
            //must make list so we can add things later

            while ((input = bufferedReader.readLine()) != null) {
                String[] row = input.split("\\|");
                //index 0 is the SKU, index 1 is ProductName, index 2 is the price, and index 3 is department

                String sku = row[0];
                String productName = row[1];
                double price = Double.parseDouble(row[2]);
                String department = row[3];
                //bundle them all together so they print together
                Product product = new Product(sku, productName, price, department);
                productList.add(product);
            }
            bufferedReader.close();

            return productList;

        } catch (IOException ex) {
            System.out.println("Failed to load csv file.");
            return new ArrayList<>();

        }

    }
}
