package module11.task5;

import java.util.stream.Stream;

public class MyStreams<T> {

    private final Stream<T> first;
    private final Stream<T> second;

    public MyStreams(Stream<T> first, Stream<T> second) {
        this.first = first;
        this.second = second;
    }

    public Stream<T> getFirst() {
        return first;
    }

    public Stream<T> getSecond() {
        return second;
    }
}
