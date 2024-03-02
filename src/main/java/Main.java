import mockdata.MockData;
import model.Person;
import model.PersonSummary;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static final List<Person> persons = MockData.getPeople();


    public static void personsOver50() {
        //List<Person> personsOver50 = persons.stream().filter(person -> person.getAge() > 50).collect(Collectors.toList());
        assert persons != null;
        List<Person> personsOver50 = persons.stream().filter(person -> person.getAge() > 50).toList();
        System.out.println("Persons over 50 years old:");
        personsOver50.forEach(System.out::println);
    }

    public static void sortedPersonsByUsername() {
        assert persons != null;
        List<Person> sortedPersonsByUsername = persons.stream()
                .sorted(Comparator.comparing(Person::getUsername))
                .toList();
        System.out.println("Persons sorted by username:");
        sortedPersonsByUsername.forEach(System.out::println);
    }

    public static void sortedPersonsByAgeAndLastName() {
        assert persons != null;
        List<Person> sortedPersons = persons.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getLastName))
                .toList();
        System.out.println("Persons sorted by age and last name:");
        sortedPersons.forEach(System.out::println);
    }

    public static void ipv4Addresses() {
        assert persons != null;
        Set<String> ipv4Addresses = persons.stream()
                .map(Person::getIpv4)
                .collect(Collectors.toSet());
        System.out.println("IPv4 addresses:");
        ipv4Addresses.forEach(System.out::println);
    }

    public static void five() {
        assert persons != null;
        List<Person> sortedByLastName = persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .toList();

        List<Person> filteredByAgeAndGender = sortedByLastName.stream()
                .filter(person -> person.getAge() > 40 && person.getGender().equals("Female"))
                .toList();

        List<Person> removedStartingWithA = filteredByAgeAndGender.stream()
                .dropWhile(person -> person.getFirstName().startsWith("A"))
                .toList();

        List<Person> afterDropping = removedStartingWithA.stream()
                .skip(5)
                .toList();

        Map<String, Person> resultMap = afterDropping.stream()
                .collect(Collectors.toMap(
                        person -> person.getFirstName() + " " + person.getLastName(),
                        person -> person
                ));

        System.out.println("Result:");
        resultMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }


    public static void six() {
      
    }


    public static void main(String[] args) {
        // personsOver50();
        //sortedPersonsByUsername();
        //sortedPersonsByAgeAndLastName();
        //ipv4Addresses();
        //five();
        six();
    }
}
