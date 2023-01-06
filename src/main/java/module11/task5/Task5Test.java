package module11.task5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5Test {

    public static void main(String[] args) {

        MyStreams<String> myStreams = new MyStreams<>(Stream.of("One", "Two", "Three", "Four"),
                Stream.of("A", "B", "C", "D", "E"));
        List<String> result = MyStreamsMerge.zip(myStreams.getFirst(), myStreams.getSecond())
                .collect(Collectors.toList());
        System.out.println(result);
    }
}