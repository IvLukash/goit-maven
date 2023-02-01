package module13.task3;

import java.io.IOException;

public class Task3Test {
    public static void main(String[] args) {
        Task3 task = new Task3();
        try {
            task.takeTodos();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
