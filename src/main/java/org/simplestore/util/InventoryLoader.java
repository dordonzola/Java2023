package org.simplestore.util;

import org.simplestore.model.Inventory;
import org.simplestore.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InventoryLoader {

    public static void loadInventory(String filePath, Inventory inventory) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int id=-1;
                try
                {
                     id = Integer.parseInt(parts[0].trim());
                }
                catch(NumberFormatException e){
                    System.err.println("Wprowadzono zły format danych!");
                }

                String name = parts[1].trim();

                double price=-1;
                try
                {
                     price = Double.parseDouble(parts[2].trim());
                }
                catch(NumberFormatException e){
                    System.err.println("Wprowadzono zły format danych!");
                }

                if (id == -1 || price == -1) {
                    throw new IllegalArgumentException("Nieprawidłowe dane produktu: " + name);
                }
                else{
                    inventory.addProduct(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
