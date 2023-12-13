package org.smartcity;

public class Apartment extends Building{
    public int residents;
    public void operate() {
        System.out.println("Apartment at " + getAddress() + " has " + residents + " residents.");
    }
}
