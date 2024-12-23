package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomReading {

    public static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return words;
    }

    public static String getRandomWord(List<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }


}
