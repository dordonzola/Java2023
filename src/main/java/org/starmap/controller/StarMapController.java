package org.starmap.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import org.starmap.model.Constellation;
import org.starmap.model.Star;
import org.starmap.utils.DataLoader;

import java.util.List;
import java.util.Optional;

// Controller for managing the star map
public class StarMapController {
    private static List<Star> stars;
    private static List<Constellation> constellations;

    public StarMapController(String dataFilePath) {
        this.stars = DataLoader.loadStars(dataFilePath);
        this.constellations = DataLoader.loadConstellations(dataFilePath, stars);
    }

    public List<Star> getStars() {
        return stars;
    }


    public List<Constellation> getConstellations() {
        return constellations;
    }


    // Get a star by its name
    public static Optional<Star> getStarByName(String name) {
        return stars.stream().filter(star -> star.getName().equalsIgnoreCase(name)).findFirst();
    }

    // Get a constellation by its name
    public static Optional<Constellation> getConstellationByName(String name) {
        return constellations.stream().filter(constellation -> constellation.getName().equalsIgnoreCase(name)).findFirst();
    }

    // Add a new star to the map
    public static void addStar(Star star) {
        stars.add(star);
    }

    // Remove a star from the map
    public static void removeStar(String name) {
        stars.removeIf(star -> star.getName().equalsIgnoreCase(name));
    }

    // Add a new constellation to the map
    public void addConstellation(Constellation constellation) {
        constellations.add(constellation);
    }

    // Remove a constellation from the map
    public void removeConstellation(String name) {
        constellations.removeIf(constellation -> constellation.getName().equalsIgnoreCase(name));
    }

    public void editStar(Star star) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Edit Star");
        dialog.setHeaderText("Change parameters");

        TextField insertName = new TextField();
        insertName.setPromptText("Name");
        insertName.setText(star.getName());

        TextField insertBrightness = new TextField();
        insertBrightness.setPromptText("Brightness");
        insertBrightness.setText(Double.toString(star.getBrightness()));

        TextField insertXPosition = new TextField();
        insertXPosition.setPromptText("X Position");
        insertXPosition.setText(Double.toString(star.getXPosition()));

        TextField insertYPosition = new TextField();
        insertYPosition.setPromptText("Y Position");
        insertYPosition.setText(Double.toString(star.getYPosition()));

        HBox line1 = new HBox(new Label("Name      "), insertName,
                new Label("Brightness"), insertBrightness);

        HBox line2 = new HBox(new Label("X Position"), insertXPosition,
                new Label("Y Position"), insertYPosition);


        VBox vbox = new VBox(line1, line2);

        line1.setSpacing(10);
        line2.setSpacing(10);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(10));

        dialog.getDialogPane().setContent(vbox);
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(newValues -> {
            star.setName(insertName.getText());
            star.setBrightness(Double.parseDouble(insertBrightness.getText()));
            star.setXPosition(Double.parseDouble(insertXPosition.getText()));
            star.setYPosition(Double.parseDouble(insertYPosition.getText()));

        });
    }




    public void randomDialog(Star star) {
        Dialog<String> dialog = new Dialog<>();
        ButtonType okButton = new ButtonType("Łelkam");

        // Utwórz duże kółko (twarz)
        Circle face = new Circle(125, 125, 80);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.BLACK);

        // Utwórz pierwsze oko
        Circle firstEye = new Circle(10);
        firstEye.setFill(Color.BLUE);
        firstEye.setStroke(Color.BLACK);
        firstEye.setLayoutX(90);
        firstEye.setLayoutY(110);

        // Utwórz drugie oko
        Circle secondEye = new Circle(10);
        secondEye.setFill(Color.BLUE);
        secondEye.setStroke(Color.BLACK);
        secondEye.setLayoutX(160);
        secondEye.setLayoutY(110);



        // Utwórz kontener Pane i dodaj do niego wszystkie elementy
        Pane pane = new Pane();
        //pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(face, firstEye, secondEye);

        // Ustaw treść dialogu jako kontener Pane
        dialog.getDialogPane().setContent(pane);

        // Dodaj przycisk OK
        dialog.getDialogPane().getButtonTypes().addAll(okButton);

        // Pobierz wynik po kliknięciu przycisku OK
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButton) {
                changeFace();
            }
            return null;
        });

        // Wyświetl dialog
        dialog.showAndWait();
    }

    private void changeFace() {

    }
}
