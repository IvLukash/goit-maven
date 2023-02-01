package module13.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Task2 {
    public static final String POST_URL = "https://jsonplaceholder.typicode.com/users/1/posts";
    public static final String COMMENT_URL = "https://jsonplaceholder.typicode.com/posts/10/comments";
    public static final Gson GSON = new Gson();
    public static final HttpClient CLIENT = HttpClient.newHttpClient();
    public void writeComments() throws IOException, InterruptedException {
        HttpRequest firstRequest = HttpRequest.newBuilder()
                .uri(URI.create(POST_URL))
                .GET()
                .build();

        HttpResponse<String> firstResponse = CLIENT.send(firstRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(firstResponse.statusCode());

        List<Post> posts = GSON.fromJson(firstResponse.body(), new TypeToken<List<Post>>() {
        }.getType());
        Optional<Integer> max = posts.stream()
                .map(Post::getId)
                .max(Integer::compareTo);
        int maxId = max.get();
        System.out.println(maxId);

        HttpRequest secondRequest = HttpRequest.newBuilder()
                .uri(URI.create(COMMENT_URL))
                .GET()
                .build();

        HttpResponse<String> secondResponse = CLIENT.send(secondRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(secondResponse.statusCode());

        List<Comment> comments = GSON.fromJson(secondResponse.body(), new TypeToken<List<Comment>>(){}.getType());
        List<String> strings = comments.stream()
                .map(Comment::getBody)
                .collect(Collectors.toList());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(strings);
        //String result = String.join(";\n", strings);
        //System.out.println(result);
        try(Writer writer = new BufferedWriter(new FileWriter("user-1-post-10-comments.json"))) {
            writer.write(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
