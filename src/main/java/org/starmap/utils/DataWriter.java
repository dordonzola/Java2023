package org.starmap.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.starmap.model.Constellation;
import org.starmap.model.Star;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataWriter {

    public static void writeStarsToFile(String filePath, List<Star> stars) {
        JSONArray starsArray = new JSONArray();
        for (Star star : stars) {
            JSONObject starJson = new JSONObject();
            starJson.put("name", star.getName());
            starJson.put("xPosition", star.getXPosition());
            starJson.put("yPosition", star.getYPosition());
            starJson.put("brightness", star.getBrightness());
            starsArray.put(starJson);
        }

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(starsArray.toString(2));
        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas zapisywania do pliku: " + filePath, e);
        }
    }

    public static void writeConstellationsToFile(String filePath, List<Constellation> constellations) {
        JSONArray constellationsArray = new JSONArray();
        for (Constellation constellation : constellations) {
            JSONObject constellationJson = new JSONObject();
            constellationJson.put("name", constellation.getName());

            JSONArray starsArray = new JSONArray();
            for (Star star : constellation.getStars()) {
                starsArray.put(star.getName());
            }
            constellationJson.put("stars", starsArray);

            constellationsArray.put(constellationJson);
        }

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(constellationsArray.toString(2)); // The second parameter is the indentation level
        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas zapisywania do pliku: " + filePath, e);
        }
    }
}
