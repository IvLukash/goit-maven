package module10.task1;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        PhoneNumbers phoneNumbers = new PhoneNumbers(new File("file1.txt"));
        String validNumbers = phoneNumbers.searchValidNumbers();
        System.out.println(validNumbers);
    }
}