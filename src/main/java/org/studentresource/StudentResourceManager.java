package org.studentresource;

import java.util.List;

// This class should manage different student resources
public class StudentResourceManager<T extends StudentResource> {
    private List<T> resources;
    public void add(T element){
        List.add(element);
    }
    public void remove(T element){
        List.remove(element);
    }
    public int find(T element){
        return List.indexOf(element);
    }    // Implement methods to manage resources (add, remove, find, etc.)

}
