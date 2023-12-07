package org.simplestore.service;

import org.junit.jupiter.api.Test;
import org.simplestore.model.Inventory;
import org.simplestore.model.Product;
import org.simplestore.model.ProductNotFoundException;
import org.simplestore.util.MyRunnable;
import org.simplestore.util.MyRunnable2;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShoppingCartConcurrencyTest {
    private final Inventory inventory = new Inventory();


    @Test
    void addAndRemoveItemsConcurrently() throws InterruptedException {
        ShoppingCart shoppingCart = new ShoppingCart(inventory);
        inventory.addProduct(new Product(1, "Test Product", 10.0));


        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyRunnable(shoppingCart));
            threads[i].start();
        }


        for (int i=0;i<10;i++){
            threads[i].join();
        }

        assertEquals(50, shoppingCart.getItemQuantity(1));
    }

    @Test
    void calculateTotalCostConcurrently() throws InterruptedException, ProductNotFoundException {
        ShoppingCart shoppingCart = new ShoppingCart(inventory);
        inventory.addProduct(new Product(1, "Test Product", 10.0));

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyRunnable2(shoppingCart));
            threads[i].start();
        }


        for (int i=0;i<10;i++){
            threads[i].join();
        }

        // Check if the total cost calculation is correct
        assertEquals(1000.0, shoppingCart.calculateTotalCost());
    }

}
