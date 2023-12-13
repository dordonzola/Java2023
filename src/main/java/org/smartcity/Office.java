package org.smartcity;

public class Office extends Building{
    public int employees;
    public void operate() {
        System.out.println("Office at " + getAddress() + " has " + employees + " employees.");
    }
}
