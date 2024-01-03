package org.starmap.model;

import org.starmap.controller.StarMapController;

import java.util.List;
import java.util.Optional;

// Represents a constellation made up of stars
public class Constellation {
    private String name;
    private List<Star> stars;

    public Constellation(String name, List<Star> stars) {
        this.name = name;
        this.stars = stars;
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Star> getStars() {
        return stars;
    }

    //Setters

    public void setName(String name) {
        this.name=name;
    }

    public void setStars(List<Star> stars) {
        this.stars=stars;
    }

    public void addStar(String starName) {
        Optional<Star> optionalStar= StarMapController.getStarByName(starName);
        optionalStar.ifPresent(star -> this.stars.add(star));
    }

    public void removeStar(String starName)
    {
        Optional<Star> star= StarMapController.getStarByName(starName);
        stars.remove(star);
    }
}
