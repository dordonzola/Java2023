//Edit stars in constellation
//(change name/brightness/position)
// możliwie przez kliknięcie myszką/przeciągnięcie.

package org.starmap.view;

import org.starmap.model.Star;

public class EditStarView {

    public void ChangeStarName(Star star, String name){
        star.setName(name);
    }

    public void ChangeStarBrightness(Star star, double brightness){
        star.setBrightness(brightness);
    }

    public void ChangeStarXPosition(Star star, double xPosition){
        star.setYPosition(xPosition);
    }

    public void ChangeStarYPosition(Star star, double yPosition){
        star.setYPosition(yPosition);
    }


//    setOnMouseClicked(event -> {
//        // Obsługa kliknięcia myszką
//        // Możesz tutaj wywołać metodę zmiany nazwy, jasności itp.
//    });
//
//    setOnMouseDragged(event -> {
//        // Obsługa przeciągnięcia myszką
//        double newX = event.getSceneX();
//        double newY = event.getSceneY();
//
//        // Ustaw nowe położenie gwiazdy
//        star.setXPosition(newX);
//        star.setYPosition(newY);
//
//        setCenterX(newX);
//        setCenterY(newY);
//    });

}
