package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class File1 {
    public static void main(String[] args) {

        String line = new String();
        try {
            Scanner scanner = new Scanner(new FileReader(new File("text.txt")));
            line = scanner.nextLine();

            System.out.println("Исходный файл: " + line);

        } catch (IOException exception) {
            System.out.println(exception);
        }

        String[] stringArr = (line.split(" "));
        Arrays.sort(stringArr);

        System.out.printf("Отсортированный список: %s",
                Arrays.toString(stringArr) + "\n");

        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : stringArr) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        for (String word : wordToCount.keySet()) {
            System.out.println(word + " " + wordToCount.get(word));
        }
        int maxValueInMap = (Collections.max(wordToCount.values()));
        for (Map.Entry<String, Integer> entry : wordToCount.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println("Cлово с максимальным количеством повторений - " + entry.getKey() + ", количество повторений - " + entry.getValue());
            }
        }
    }
}





