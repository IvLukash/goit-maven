package module11.task4;

import java.util.stream.Stream;

public class MyRandom {

    private final long first;

    public MyRandom(long first) {
        this.first = first;
    }

    public  Stream<Long> random(long a, long c, long m) {
        return Stream.iterate(first, n -> (a * n + c) % m);
    }
}
