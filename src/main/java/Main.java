
import mockdata.MockData;
import model.Person;
import model.PersonSummary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Person> persons = MockData.getPeople();


    public static void personsOver50() {
        //List<Person> personsOver50 = persons.stream().filter(person -> person.getAge() > 50).collect(Collectors.toList());
        assert persons != null;
        List<Person> personsOver50 = persons.stream().filter(person -> person.getAge() > 50).toList();
        System.out.println("Persons over 50 years old: ");
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


    public static void processPeople() {
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

        Map<String, Person> resultMap = removedStartingWithA.stream()
                .collect(Collectors.toMap(
                        person -> person.getFirstName() + " " + person.getLastName(),
                        person -> person,
                        (existing, replacement) -> existing))
                .entrySet().stream()
                .skip(5)
                .limit(100)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Result:");
        resultMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void six() {
        // Convert Person objects to PersonSummary objects
        assert persons != null;
        List<PersonSummary> personSummaryList = persons.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("male"))
                .map(person -> new PersonSummary(person.getId(), person.getFirstName(), person.getLastName(), person.getAge(), parseDate(person.getBirthDate())))
                .toList();
        // Calculate ages for each person
        for (PersonSummary personSummary : personSummaryList) {
            int age = calculateAge(personSummary.getBirthDate());
            System.out.println(personSummary.getFirstName() + " " + personSummary.getLastName() + "'s age: " + age);
        }

        // Calculate average age for males
        double averageMaleAge = personSummaryList.stream()
                .mapToInt(personSummary -> calculateAge(personSummary.getBirthDate())).average()
                .orElse(0.0);
        System.out.println("Average age of males: " + averageMaleAge);
    }

    // Method to calculate age based on birthdate
    public static int calculateAge(Date birthDate) {
        Date now = new Date();
        int age = now.getYear() - birthDate.getYear();
        if (now.getMonth() < birthDate.getMonth() || (now.getMonth() == birthDate.getMonth() && now.getDate() < birthDate.getDate())) {
            age--;
        }
        return age;
    }

    // Method to parse date string into Date object
    public static Date parseDate(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // personsOver50();
        //sortedPersonsByUsername();
        //sortedPersonsByAgeAndLastName();
        //ipv4Addresses();
        processPeople();
        //six();
    }
}
