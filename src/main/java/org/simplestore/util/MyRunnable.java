package org.simplestore.util;

import org.simplestore.service.ShoppingCart;

public class MyRunnable implements Runnable {
    private final ShoppingCart shoppingCart;

    public MyRunnable(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public void run() {
        for (int i=0;i<10;i++)
        {
            shoppingCart.addItem(1, 1);
        }

        for (int i=0;i<5;i++)
        {
            shoppingCart.removeItem(1, 1);
        }
    }
}
