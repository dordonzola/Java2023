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

    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}

    public String toString(){
        return "Product{id="+this.id+", name='"+this.name+"', price="+this.price+"}";
    }

}
