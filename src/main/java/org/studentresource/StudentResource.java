package org.studentresource;

public interface StudentResource {
    String id;
    String name;
    
    String getId();
    String getName();
    // Add other necessary methods here
    void setId(String newId);
    void setName(String newName);

}