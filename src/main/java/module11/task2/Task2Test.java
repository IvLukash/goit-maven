package module11.task2;

import module11.task1.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2Test {
    public static void main(String[] args) {
        PeoplesList people = new PeoplesList();

        List<String> result = people.getPeople().stream()
                .map(name -> name.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
