package org.simplestore.service;

import org.junit.jupiter.api.Test;
import org.simplestore.model.Inventory;
import org.simplestore.model.Product;
import org.simplestore.model.ProductNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShoppingCartConcurrencyTest {
    private final Inventory inventory = new Inventory();


    @Test
    void addAndRemoveItemsConcurrently() throws InterruptedException {
        ShoppingCart shoppingCart = new ShoppingCart(inventory);
        inventory.addProduct(new Product(1, "Test Product", 10.0));

        for (int i=0;i<10;i++)
        {
            Thread addThread=new Thread(() ->{
                for (int j=0;j<10;j++){
                    shoppingCart.addItem(1,1);
                }
        });
            addThread.start();
        }

        for (int i=0;i<10;i++)
        {
            Thread removeThread=new Thread(() ->{
                for (int j=0;j<5;j++){
                    shoppingCart.removeItem(1,1);
                }
            });
            removeThread.start();
        }

        Thread.sleep(2000);

        assertEquals(50, shoppingCart.getItemQuantity(1));
    }

    @Test
    void calculateTotalCostConcurrently() throws InterruptedException, ProductNotFoundException {
        ShoppingCart shoppingCart = new ShoppingCart(inventory);
        inventory.addProduct(new Product(1, "Test Product", 10.0));

        double totalPrice=0;
        for (int i=0;i<10;i++)
        {
            Thread addThread=new Thread(() ->{
                for (int j=0;j<10;j++){
                    shoppingCart.addItem(1,1);
                }
            });
            addThread.start();
        }
        Thread.sleep(2000);



        assertEquals(1000.0, shoppingCart.calculateTotalCost());
    }

}
