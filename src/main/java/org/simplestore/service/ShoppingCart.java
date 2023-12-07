package org.simplestore.service;

import org.simplestore.model.Inventory;
import org.simplestore.model.Product;
import org.simplestore.model.ProductNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Remember of synchronization logic!
    // It could be achieved in many ways.
    private final Inventory inventory;
    private final Map<Integer, Integer> cartItems = new HashMap<>();

    public ShoppingCart() {
        this.inventory=null;
    }
    public ShoppingCart(Inventory inventory) {
        this.inventory=inventory;
    }

    public void addItem(int productId, int quantity) {
        cartItems.merge(productId, quantity, Integer::sum);  // Equivalent of lambda (a, b) -> Integer.sum(a, b)
    }

    public int getItemQuantity(int item) {
        return cartItems.get(item);
    }

    public void removeItem(int item, int quantity) {
        int currentQuantity=cartItems.get(item);
        if (currentQuantity>=quantity){
            cartItems.remove(item);
            if (currentQuantity>quantity){
                cartItems.put(item,currentQuantity-quantity);
            }
        }
        else {
            System.out.println("Błąd! Próba usunięcia większej ilości produktów niż dostepna!");
        }
    }

    public void clearCart() {

        for(Map.Entry<Integer, Integer> item : cartItems.entrySet()){
            cartItems.put(item.getKey(), 0);
        }
    }

    public double calculateTotalCost() throws ProductNotFoundException {
        double cost=0;
        int id;
        for(Map.Entry<Integer, Integer> entry : cartItems.entrySet()){
            id=entry.getKey();
            Product product=inventory.getProduct(id);
            cost+= product.getPrice()*entry.getValue();
        }
        return cost;
    }


}
