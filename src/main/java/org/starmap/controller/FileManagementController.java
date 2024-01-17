package org.starmap.controller;

import org.starmap.model.Constellation;
import org.starmap.model.Star;
import org.starmap.utils.DataLoader;
import org.starmap.utils.DataWriter;

import java.util.List;

public class FileManagementController {
    public List<Constellation> loadConstellations(String filePath, List<Star> stars) {
        return DataLoader.loadConstellations(filePath,stars);
    }

    public List<Star> loadStars(String filePath) {
         return DataLoader.loadStars(filePath);
    }

    public void writeConstellations(String filePath, List<Constellation> constellations) {
        DataWriter.writeConstellationsToFile(filePath,constellations);
    }

    public void writeStars(String filePath, List<Star> stars) {
        DataWriter.writeStarsToFile(filePath, stars);
    }
}
