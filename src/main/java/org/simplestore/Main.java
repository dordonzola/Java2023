package org.simplestore;

import org.simplestore.model.Inventory;
import org.simplestore.model.Product;
import org.simplestore.service.ShoppingCart;
import org.simplestore.util.InventoryLoader;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        InventoryLoader.loadInventory("/src/main/resources/inventory.txt", inventory);

        // Implement example usage of application components
        ShoppingCart shoppingCart1=new ShoppingCart();

        shoppingCart1.addItem(1,4);
        shoppingCart1.addItem(2,1);
        shoppingCart1.addItem(3,5);
        shoppingCart1.addItem(4,1);
        shoppingCart1.addItem(5,2);
        shoppingCart1.addItem(6,2);



        ShoppingCart shoppingCart2=new ShoppingCart();

        shoppingCart2.addItem(7,1);
        shoppingCart2.addItem(8,7);
        shoppingCart2.addItem(9,2);
        shoppingCart2.addItem(10,2);
        shoppingCart2.addItem(5,4);
        shoppingCart2.addItem(6,1);



        ShoppingCart shoppingCart3=new ShoppingCart();



        Product product11=new Product(11, "Christmas Tree", 80.00);
        Product product12=new Product(12, "Lamps", 40.00);
        Product product13=new Product(13, "Carpet", 120.00);

        shoppingCart3.addItem(1,1);
        shoppingCart3.addItem(2,7);
        shoppingCart3.addItem(3,2);
        shoppingCart3.addItem(4,2);
        shoppingCart3.addItem(5,1);
        shoppingCart3.addItem(6,8);
        //Dodajemy nowe pozycje
        shoppingCart3.addItem(11,2);
        shoppingCart3.addItem(12,1);
        shoppingCart3.addItem(13,8);

        shoppingCart1.clearCart();





        //Handle exceptions, etc.

        // TODO: Add product to inventory, list all products
        // TODO: Remove product from inventory, list all products
    }
}

