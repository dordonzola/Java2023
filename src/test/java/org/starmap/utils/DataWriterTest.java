package org.starmap.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.starmap.model.Constellation;
import org.starmap.model.Star;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataWriterTest {
    Star star1=new Star("Gwiazda1",1,2,3);
    Star star2=new Star("Gwiazda2",0,0,0);
    List<Star> stars= new ArrayList<>();

    Star star3=new Star("Gwiazda3",5,2,5);
    Star star4=new Star("Gwiazda4",3,5,2);
    List<Star> stars2= new ArrayList<>();


    Constellation constellation1=new  Constellation("Konstelacja1",stars);
    Constellation constellation2=new  Constellation("Konstelacja2",stars2);

    List<Constellation> constellations= new ArrayList<>();



    @TempDir
    Path tempDir;
    private Path testFilePath;

    @BeforeEach
    void setUp()  {
        testFilePath = tempDir.resolve("test.json");

        stars.add(star1);
        stars.add(star2);

        stars2.add(star3);
        stars2.add(star4);

        constellations.add(constellation1);
        constellations.add(constellation2);

    }

    @Test
    void writeStarsTest() {
        DataWriter.writeStarsToFile(testFilePath.toString(), stars);
        assertTrue(Files.exists(testFilePath));

        try {
            List<String> lines = Files.readAllLines(testFilePath);
            String jsonContent = String.join("", lines);
            JSONArray actualJsonArray = new JSONArray(jsonContent);

            JSONArray expectedJsonArray = new JSONArray();
            JSONObject star1Json = new JSONObject();
            star1Json.put("name", "Gwiazda1");
            star1Json.put("xPosition", 1.0);
            star1Json.put("yPosition", 2.0);
            star1Json.put("brightness", 3.0);
            expectedJsonArray.put(star1Json);

            JSONObject star2Json = new JSONObject();
            star2Json.put("name", "Gwiazda2");
            star2Json.put("xPosition", 0.0);
            star2Json.put("yPosition", 0.0);
            star2Json.put("brightness", 0.0);
            expectedJsonArray.put(star2Json);

            assertEquals(expectedJsonArray.toString(), actualJsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void writeConstellationsTest() {
        DataWriter.writeConstellationsToFile(testFilePath.toString(), constellations);
        assertTrue(Files.exists(testFilePath));

        try {
            List<String> lines = Files.readAllLines(testFilePath);
            String jsonContent = String.join("", lines);
            JSONArray actualJsonArray = new JSONArray(jsonContent);

            JSONArray expectedJsonArray = new JSONArray();
            JSONObject constellation1Json = new JSONObject();
            constellation1Json.put("name", "Konstelacja1");

            JSONArray starsArray1 = new JSONArray();
            starsArray1.put("Gwiazda1");
            starsArray1.put("Gwiazda2");
            constellation1Json.put("stars", starsArray1);
            expectedJsonArray.put(constellation1Json);

            JSONObject constellation2Json = new JSONObject();
            constellation2Json.put("name", "Konstelacja2");

            JSONArray starsArray2 = new JSONArray();
            starsArray2.put("Gwiazda3");
            starsArray2.put("Gwiazda4");
            constellation2Json.put("stars", starsArray2);
            expectedJsonArray.put(constellation2Json);

            assertEquals(expectedJsonArray.toString(), actualJsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
