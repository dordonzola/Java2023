package org.smartcity;

public class Office extends Building{
    public int employees;

    public Office(String address, int floors, int employees){
        super(address, floors);
        this.employees=employees;

    }
    public void operate() {
        System.out.println("Office at " + getAddress() + " has " + employees + " employees.");
    }
}
