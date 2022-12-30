package module10.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter {
    private final File sourceFile;
    private final File targetFile;

    public JsonWriter(File sourceFile, File targetFile) {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
    }

    public String readFile() {
        StringBuilder builder = new StringBuilder();
        String text = "";

        try (Reader reader = new BufferedReader(new FileReader(sourceFile))) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
            text = builder.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }

    public String parseToJson() {
        String text = readFile();

        List<User> listUsers = new ArrayList<>();
        String[] users = text.split("\r\n");

        for (int i = 1; i < users.length; i++) {
            String[] someUser = users[i].split(" ");
            listUsers.add(new User(someUser[0], Integer.parseInt(someUser[1])));
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(listUsers);
    }

    public void writeFile() {
        try(Writer writer = new BufferedWriter(new FileWriter(targetFile))) {
            writer.write(parseToJson());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
