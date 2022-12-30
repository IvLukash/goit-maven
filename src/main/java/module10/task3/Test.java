package module10.task3;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        WordsFrequency frequency = new WordsFrequency(new File("words.txt"));
        System.out.println(frequency.countWordsFrequency());
    }
}