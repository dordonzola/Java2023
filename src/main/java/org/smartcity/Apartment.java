package org.smartcity;

public class Apartment extends Building{
    public int residents;

    public Apartment(String address, int floors, int residents){
        super(address, floors);
        this.residents=residents;
    }

    public void operate() {
        System.out.println("Apartment at " + getAddress() + " has " + residents + " residents.");
    }
}
