package module13.task1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public class HTTPUtils {
    public static HttpClient CLIENT = HttpClient.newHttpClient();
    public static String URL = "https://jsonplaceholder.typicode.com/users";
    public static Gson GSON = new Gson();

    public static User createUser() {
        User user = new User();
        user.setId(maxId() + 1);
        user.setName("Harry Potter");
        user.setUsername("Wizard");
        return user;
    }

    public static int maxId() {
        HttpRequest getUsersRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(getUsersRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<User> users = GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
        Optional<Integer> max = users.stream()
                .map(User::getId)
                .max(Integer::compareTo);
        return max.get();
    }
    public static void sendUser() {
        HttpRequest sendRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .POST(HttpRequest.BodyPublishers.ofString(GSON.toJson(HTTPUtils.createUser())))
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(sendRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void updateUser() {
        HttpRequest updateRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", URL, 10)))
                .PUT(HttpRequest.BodyPublishers.ofString(GSON.toJson(HTTPUtils.createUser())))
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(updateRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void deleteUser() {
        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", URL, 10)))
                .DELETE()
                .build();

        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.statusCode());
    }

    public static void getUsers() {
        HttpRequest getUsersRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(getUsersRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void getUserById() {
            HttpRequest getUserByIdRequest = HttpRequest.newBuilder()
                    .uri(URI.create(String.format("%s?id=%d", URL, 2)))
                    .GET()
                    .build();

        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(getUserByIdRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.statusCode());
            System.out.println(response.body());
    }

    public static void getUserByUserName() {
        HttpRequest getUserByUserNameRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s?username=%s",URL, "Delphine")))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(getUserByUserNameRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
