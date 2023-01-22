package module12.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadsTask2 {
    private final List<Integer> integerList;
    private List<String> stringList;

    public ThreadsTask2(int n) {
        this.integerList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            integerList.add(i);
        }
        this.stringList = change();
    }

    private List<String> change() {
        return integerList.stream()
                .map(n -> Integer.toString(n))
                .collect(Collectors.toList());
    }
    public synchronized void fizz() {
        for (int i = 0; i < integerList.size(); i++) {
            if(integerList.get(i) % 3 == 0) {
                stringList.set(i, "fizz");
            }
        }
    }

    public synchronized void buzz() {
        for (int i = 0; i < integerList.size(); i++) {
            if(integerList.get(i) % 5 == 0) {
                stringList.set(i, "buzz");
            }
        }
    }

    public synchronized void fizzbuzz() {
        for (int i = 0; i < integerList.size(); i++) {
            if(integerList.get(i) % 15 == 0) {
                stringList.set(i, "fizzbuzz");
            }
        }
    }

    public void number() {
        System.out.println(String.join(", ", stringList));
    }
}
