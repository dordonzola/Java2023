package org.studentresource.decorator;

import org.studentresource.StudentResource;

public class RateableResource extends ResourceDecorator{
    double rate;
    public RateableResource(StudentResource decoratedResource) {
        super(decoratedResource);
    }
    public void setRating(double rate){
        this.rate=rate;
    }
    public double getRating(){
        return rate;
    }


}
