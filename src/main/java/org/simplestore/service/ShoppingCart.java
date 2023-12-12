package org.simplestore.service;

import org.simplestore.model.Inventory;
import org.simplestore.model.Product;
import org.simplestore.model.ProductNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Inventory inventory;
    private final Map<Integer, Integer> cartItems = new HashMap<>();

    public  ShoppingCart() {
        this.inventory=null;
    }
    public ShoppingCart(Inventory inventory) {
        this.inventory=inventory;
    }

    public synchronized void addItem(int productId, int quantity) {
        cartItems.merge(productId, quantity, Integer::sum);
    }

    public synchronized int getItemQuantity(int item) {
        return cartItems.get(item);
    }

    public synchronized void removeItem(int item, int quantity) throws IllegalArgumentException {
        int afterDeleting=cartItems.get(item)-quantity;
        if (afterDeleting>=0){
            cartItems.remove(item);
            if (afterDeleting>0){
                cartItems.put(item,afterDeleting);
            }
        }
        else {
            throw new IllegalArgumentException("Błąd! Próba usunięcia większej ilości produktów niż dostepna!");
        }
    }

    public synchronized void clearCart() {

        cartItems.clear();
    }

    public synchronized double calculateTotalCost() throws ProductNotFoundException {
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
