//Edit current constellation
// (add/remove/move/change name)

package org.starmap.view;

import org.starmap.model.Constellation;
import org.starmap.model.Star;
import org.starmap.controller.StarMapController;

import java.util.Optional;

public class EditConstellationView {

    public void addStarToConstellation(String starName, double xPosition, double yPosition, double brightness,String constellationName) {
        //create new star and add to StarMapController
        Star star=new Star(starName, xPosition, yPosition, brightness);
        StarMapController.addStar(star);

        //get constellation by name and add star to constellation
        Optional<Constellation> optionalConstellation=StarMapController.getConstellationByName(constellationName);
        optionalConstellation.ifPresent(constellation -> constellation.addStar(starName));
    }

    public void removeStarFromConstellation(String starName, String constellationName){
        //remove from StarMapController
        StarMapController.removeStar(starName);

        //get constellation by name and remove star from constellation
        Optional<Constellation> optionalConstellation=StarMapController.getConstellationByName(constellationName);
        optionalConstellation.ifPresent(constellation -> constellation.removeStar(starName));

    }

    public void moveStarInConstellation(String starName, double newXPosition,double newYPosition){
        //get star by name
        Optional<Star> optionalStar=StarMapController.getStarByName(starName);

        //set new x and y position
        optionalStar.ifPresent(star -> star.setXPosition(newXPosition));
        optionalStar.ifPresent(star -> star.setXPosition(newYPosition));

    }

    public void changeConstellationName(String oldName, String newName ){
        //get constellation by nae and set new name
        Optional<Constellation> optionalConstellation=StarMapController.getConstellationByName(oldName);
        optionalConstellation.ifPresent(constellation -> constellation.setName(newName));
    }
}
