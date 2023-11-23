package org.studentresource.decorator;

import org.studentresource.StudentResource;

public class RateableResource extends ResourceDecorator{
    int rate;
    public RateableResource(StudentResource decoratedResource) {
        super(decoratedResource);
    }
    public void rateResource(int rate){
        this.rate=rate;
    }


}
