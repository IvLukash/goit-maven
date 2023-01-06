package module11.task1;

import java.util.ArrayList;
import java.util.List;

public class PeoplesList {
    private final List<Person> people;

    public PeoplesList() {
        people = new ArrayList<>();
        people.add(new Person(1, "Sara"));
        people.add(new Person(2, "Viktor"));
        people.add(new Person(3, "Petro"));
        people.add(new Person(4, "John"));
        people.add(new Person(5, "Sam"));
        people.add(new Person(6, "Bohdan"));
        people.add(new Person(7, "Boris"));
        people.add(new Person(8, "Olha"));
        people.add(new Person(9, "Bred"));;
    }

    public List<Person> getPeople() {
        return people;
    }
}
