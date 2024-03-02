import mockdata.MockData;
import model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static final List<Person> persons = MockData.getPeople();
    public static void personsOver50(){
        //List<Person> personsOver50 = persons.stream().filter(person -> person.getAge() > 50).collect(Collectors.toList());
       assert persons != null;
       List<Person> personsOver50 = persons.stream().filter(person -> person.getAge() > 50).toList();
      System.out.println("Persons over 50 years old:");
       personsOver50.forEach(System.out::println);
    }


    public static void main(String[] args) {
        personsOver50();

    }
}
