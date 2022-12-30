package module10.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {

    private File file;

    public PhoneNumbers(File file) {
        this.file = file;
    }

    public String readFile() {
        StringBuilder result = new StringBuilder();
        if (!file.exists()) {
            return "This file doesn't exist!";
        }
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result.toString();
    }

    public String searchValidNumbers() {
        String phoneNumbers = readFile();
        StringBuilder result = new StringBuilder();
        Pattern pat = Pattern.compile("(\\(\\d{3}\\)\\s|\\d{3}-)\\d{3}-\\d{4}");
        Matcher mat = pat.matcher(phoneNumbers);
        while(mat.find()) {
            result.append(mat.group()).append("\n");
        }
        return result.toString();
    }
}