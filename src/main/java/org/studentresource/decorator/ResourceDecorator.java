package org.studentresource.decorator;

import org.studentresource.StudentResource;

public abstract class ResourceDecorator implements StudentResource {
    protected StudentResource decoratedResource;

    private String id=null;
    private String name=null;
    public ResourceDecorator(StudentResource decoratedResource) {
        this.decoratedResource = decoratedResource;
    }

    @Override
    public String getId(){
        return id;
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setId(String newId){
        this.id=newId;
    }
    @Override
    public void setName(String newName){
        this.name=newName;
    }

    public Object getDecoratedResource() {
        return decoratedResource;
    }
}
