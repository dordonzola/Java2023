package org.simplestore.model;

public class Product {
    private final int id;
    private final String name;
    private final double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public synchronized int getId(){return this.id;}
    public synchronized String getName(){return this.name;}
    public synchronized double getPrice(){return this.price;}

    public synchronized String toString(){
        return "Product{id="+this.id+", name='"+this.name+"', price="+this.price+"}";
    }

}
