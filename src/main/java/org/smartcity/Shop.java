package org.smartcity;

public class Shop extends Building{
    public String type;

    public Shop(String address, int floors, String type ){
        super(address, floors);
        this.type=type;
    }

    @Override
    public synchronized void operate() {
        System.out.println("Shop at " + getAddress() + " is a " + type + " shop.");
    }
}
