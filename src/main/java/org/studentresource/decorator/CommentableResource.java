package org.studentresource.decorator;

import org.studentresource.StudentResource;

// This class should allow adding comments to the resource
public class CommentableResource extends ResourceDecorator {
    String comment;
    public CommentableResource(StudentResource decoratedResource) {
        super(decoratedResource);
    }

    // Implement commenting features
    public void addComment(String comment){
        this.comment=comment;
    }
}
