package module11.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1Test {

    public static void main(String[] args) {

        PeoplesList people = new PeoplesList();

        List<String> result = people.getPeople().stream()
                .filter(number -> number.getIndex() % 2 != 0)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(result);

        System.out.println(oddIndexName(Arrays.asList("Petro", "Ivan", "Max", "Maria", "Robin", "Anna")));
    }

    public static String oddIndexName(List<String> namesList) {
        return IntStream.range(0, namesList.size())
                .filter(number -> number % 2 != 0)
                .mapToObj(number -> number + ". " + namesList.get(number))
                .collect(Collectors.joining(", "));
    }
}
