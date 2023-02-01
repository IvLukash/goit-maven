package module13.task3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static final String URL = "https://jsonplaceholder.typicode.com/users/1/todos";

    public void takeTodos() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List<ToDoSomething> todos = gson.fromJson(response.body(), new TypeToken<List<ToDoSomething>>(){}.getType());

        String result = todos.stream()
                .filter(ToDoSomething::isCompleted)
                .map(ToDoSomething::getTitle)
                .collect(Collectors.joining(",\n"));

        System.out.println(result);
    }
}
