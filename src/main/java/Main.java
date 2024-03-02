import mockdata.MockData;
import model.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = MockData.getPeople();

        //List<Person> personsOver50 = persons.stream().filter(person -> person.getAge() > 50).collect(Collectors.toList());
        List<Person> personsOver50 = persons.stream().filter(person -> person.getAge() > 50).toList();

        System.out.println("Persons over 50 years old:");
        personsOver50.forEach(System.out::println);

    }
}
