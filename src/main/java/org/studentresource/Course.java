package org.studentresource;

public class Course implements StudentResource {

    private String id=null;
    private String name=null;

    public Course(String id, String name){
        this.id=id;
        this.name=name;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setId(String newId){
        id=newId;
    }
    public void setName(String newName){
        name=newName;
    }


}