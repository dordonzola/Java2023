package org.studentresource.decorator;

import org.studentresource.StudentResource;

public abstract class ResourceDecorator implements StudentResource {
    protected StudentResource decoratedResource;

    public ResourceDecorator(StudentResource decoratedResource) {
        this.decoratedResource = decoratedResource;
    }

    // Implement all necessary methods from StudentResource
    // Override methods to add additional behaviors

    @Override
    String getId(){
        return id;
    }
    @Override
    String getName(){
        return name;
    }
    // Add other necessary methods here
    @Override
    void setId(String newId){
        this.id=newId;
    }
    @Override
    void setName(String newName){
        this.name=newName;
    }

}
