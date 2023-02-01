package module13.task2;

import java.io.IOException;

public class Task2Test {


    public static void main(String[] args) {
        Task2 task = new Task2();
        try {
            task.writeComments();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
