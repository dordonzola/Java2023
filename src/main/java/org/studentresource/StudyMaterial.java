package org.studentresource;

public class StudyMaterial implements StudentResource{

    private String id;
    private String name;

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
