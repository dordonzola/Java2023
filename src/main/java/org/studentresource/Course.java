package org.studentresource;

public class Course implements StudentResource {


    public Course(String id, String name){
        this.id=id;
        this.name=name;
    }

    // Constructor, getters, setters
    // Implement all necessary methods from StudentResource
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    // Add other necessary methods here
    public void setId(String newId){
        id=newId;
    }
    public void setName(String newName){
        name=newName;
    }


}