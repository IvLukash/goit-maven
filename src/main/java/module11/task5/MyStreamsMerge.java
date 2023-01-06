package module11.task5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MyStreamsMerge {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> result = new ArrayList<>();
        Iterator<T> one = first.iterator();
        Iterator<T> two = second.iterator();
        while (one.hasNext() && two.hasNext()) {
            result.add(one.next());
            result.add(two.next());
        }
        return result.stream();
    }
}