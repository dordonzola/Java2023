package org.simplestore.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    // TODO: Remember of synchronization logic!
    // There is several methods to achieve this.
    private final Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProduct(int id) throws ProductNotFoundException {
        Product product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }
        return product;
    }

    public Collection<Product> listAllProducts() {
        return products.values();
    }

    public void removeProduct(int id) {
        products.remove(id);
    }



}
