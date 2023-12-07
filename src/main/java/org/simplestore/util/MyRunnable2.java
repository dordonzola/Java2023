package org.simplestore.util;

import org.simplestore.service.ShoppingCart;

public class MyRunnable2 implements Runnable {
    private final ShoppingCart shoppingCart;

    public MyRunnable2(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public void run() {
        for (int i=0;i<10;i++)
        {
            shoppingCart.addItem(1, 1);
        }

    }
}
