package org.smartcity;

public class Shop extends Building{
    public String type;
    public void operate() {
        System.out.println("Shop at " + getAddress() + " is a " + type + " shop.");
    }
}
