package org.studentresource;

public class Course implements StudentResource {
    private String id;
    private String name;

    void Course(String id, String name){
        this.id=id;
        this.name=name;
    }

    // Constructor, getters, setters
    // Implement all necessary methods from StudentResource
    String getId(){
        return id;
    }
    String getName(){
        return name;
    }
    // Add other necessary methods here
    void setId(String newId){
        id=newId;
    }
    void setName(String newName){
        name=newName;
    }


}