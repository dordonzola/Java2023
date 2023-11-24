package org.studentresource;

import java.util.ArrayList;
import java.util.List;

public class StudentResourceManager <T extends StudentResource> implements Cloneable {
    private List<T> resources;
    public StudentResourceManager() {
        this.resources = new ArrayList<>();
    }

    public void addResource(T element){
        resources.add(element);
    }
    public void removeResource(T element){
        resources.remove(element);
    }
    public T getResource(String id){
        for (T resource : resources) {
            if (resource.getId().equals(id)) {
                return resource;
            }
        }
        return null;
    }

    @Override
    public StudentResourceManager<T> clone() {
        try {
            StudentResourceManager clone = (StudentResourceManager) super.clone();
            clone.resources = new ArrayList<>(this.resources);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
