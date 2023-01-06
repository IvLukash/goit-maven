package module11.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1Test {

    public static void main(String[] args) {

        PeoplesList people = new PeoplesList();

        List<String> result = people.getPeople().stream()
                .filter(number -> number.getIndex() % 2 != 0)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
