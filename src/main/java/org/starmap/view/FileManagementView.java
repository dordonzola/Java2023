package org.starmap.view;

import org.starmap.controller.FileManagementController;
import org.starmap.model.Constellation;
import org.starmap.model.Star;

import java.util.List;

public class FileManagementView {

    private final FileManagementController controller;

    public FileManagementView(FileManagementController controller) {
        this.controller = controller;
    }

    public void loadConstellationsFromJSON(String filePath, List<Star> stars) {
        controller.loadConstellations(filePath, stars);
    }

    public void loadStarsFromJSON(String filePath) {
        controller.loadStars(filePath);
    }

    public void writeConstellationsToJSON(String filePath, List<Constellation> constellations) {
        controller.writeConstellations(filePath, constellations);
    }

    public void writeStarsToJSON(String filePath, List<Star> stars) {
        controller.writeStars(filePath,  stars);
    }
}
