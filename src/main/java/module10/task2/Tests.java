package module10.task2;

import java.io.File;

public class Tests {
    public static void main(String[] args) {
        JsonWriter writer = new JsonWriter(new File("file2.txt"), new File("user.json"));
        writer.writeFile();
    }
}