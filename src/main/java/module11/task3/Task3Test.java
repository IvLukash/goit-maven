package module11.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Task3Test {
    public static void main(String[] args) {
        String[] someText = {"14, 156, 123, 45", "1, 2, 0", "4, 5", "9, 15, 17, 6"};

        String result = Arrays.stream(someText)
                .map(word -> word.split(", "))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
