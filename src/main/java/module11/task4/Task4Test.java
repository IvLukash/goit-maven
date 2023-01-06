package module11.task4;

import java.util.List;
import java.util.stream.Collectors;

public class Task4Test {
    public static void main(String[] args) {
        MyRandom myRandom = new MyRandom(125);

        List<Long> result = myRandom.random(25214903917L, 11L, 2^48)
                .limit(20)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
