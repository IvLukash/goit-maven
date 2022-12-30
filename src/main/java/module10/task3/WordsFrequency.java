package module10.task3;

import java.io.*;
import java.util.*;

public class WordsFrequency {
    private final File file;

    public WordsFrequency(File file) {
        this.file = file;
    }

    public String readFile() {
        StringBuilder builder = new StringBuilder();
        String text = "";

        try (Reader reader = new BufferedReader(new FileReader(file))) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
            text = builder.toString().strip();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }

    public String countWordsFrequency() {
        String[] words = readFile().split("\\s+");

        Map<String, Integer> myMap = new HashMap<>();
        for (String word : words) {
            if (!myMap.containsKey(word)) {
                myMap.put(word, 1);
            } else {
                myMap.put(word, myMap.get(word) + 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = myMap.entrySet();

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries) {
            result.append(entry.getValue()).append(" ").append(entry.getKey()).append("\n");
        }
        String[] results = result.toString().strip().split("\n");
        Arrays.sort(results, Collections.reverseOrder());

        StringBuilder wordsFrequency = new StringBuilder();
        for (String symbols : results) {
            String[] array = symbols.split(" ");
            wordsFrequency.append(array[1]).append(" ").append(array[0]).append("\n");
        }
        return wordsFrequency.toString().strip();
    }
}
